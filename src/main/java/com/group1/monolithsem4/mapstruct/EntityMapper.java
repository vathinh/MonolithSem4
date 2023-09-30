package com.group1.monolithsem4.mapstruct;


import com.group1.monolithsem4.model.UserEntity;
import com.group1.monolithsem4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class EntityMapper {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    public UserEntity mappingUser(Integer userId) {
        if (userId == null) {
            return null;
        }
        Optional<UserEntity> userEntityMono = userRepository.findById(userId);
        return userEntityMono.orElse(null);
    }

}
