package com.group1.monolithsem4.service.impl;


import com.group1.monolithsem4.dto.user.UserCriteria;
import com.group1.monolithsem4.dto.user.UserRequest;
import com.group1.monolithsem4.dto.user.UserResponse;
import com.group1.monolithsem4.dto.user.UserUpdateRequest;
import com.group1.monolithsem4.exception.InvalidPermissionException;
import com.group1.monolithsem4.exception.ResourceNotFoundException;
import com.group1.monolithsem4.mapstruct.UserMapper;
import com.group1.monolithsem4.model.UserEntity;
import com.group1.monolithsem4.repository.UserRepository;
import com.group1.monolithsem4.service.AccountService;
import com.group1.monolithsem4.service.UserService;
import com.group1.monolithsem4.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    private final EntityManager entityManager;

    private final AccountService accountService;

    private final UserSpecification userSpecification;

    private ResourceNotFoundException resourceNotFoundException() {
        return new ResourceNotFoundException("No user found with the given email");
    }

    private InvalidPermissionException invalidPermissionException() {
        return new InvalidPermissionException("You cant access to other profile");
    }


    @Override
    @Transactional
    public void create(UserRequest request) {
        request.setKeycloakId(accountService.createKeycloak(request));
        UserEntity userEntity = mapper.toEntity(request);
        userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public UserResponse getById(Integer id) {
        return userRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(this::resourceNotFoundException);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> getAllByCriteria(UserCriteria userCriteria) {
        return userRepository.findAll(userSpecification.getUserCriteria(userCriteria), userCriteria.getPageable())
                .map(mapper::toResponse);
    }

    @Override
    @Transactional
    public void updateUser(Integer id, UserUpdateRequest userUpdateRequest) throws NotFoundException {
        UserEntity existed = userRepository.findByIdAndDeleteFlag(id, false).orElseThrow();
        entityManager.detach(existed);
        mapper.updateEntity(userUpdateRequest, existed);
        userRepository.save(existed);
    }

    @Override
    @Transactional
    public void deleteUsers(Map<Integer, Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<UserEntity> deleteUsers = userRepository.findAllById(ids.keySet());
            deleteUsers.forEach(userEntity -> {
                userEntity.setVersion(ids.get(userEntity.getId()));
                userEntity.setDeleteFlag(true);
                entityManager.detach(userEntity);
            });
            userRepository.saveAll(deleteUsers);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public UserResponse getCustomerByEmail(String keycloakId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return Optional.ofNullable(authentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getName)
                .filter(keycloakId::equals)
                .map(userKeycloakId -> userRepository.findByKeycloakId(keycloakId).orElseThrow(this::resourceNotFoundException))
                .map(mapper::toResponse)
                .orElseThrow(this::invalidPermissionException);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email).orElseThrow(this::resourceNotFoundException);
        return mapper.toResponse(entity);
    }
}
