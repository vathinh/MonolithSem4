package com.group1.monolithsem4.service;


import com.group1.monolithsem4.dto.user.UserCriteria;
import com.group1.monolithsem4.dto.user.UserRequest;
import com.group1.monolithsem4.dto.user.UserResponse;
import com.group1.monolithsem4.dto.user.UserUpdateRequest;
import com.group1.monolithsem4.model.UserEntity;
import org.springframework.data.domain.Page;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Map;

public interface UserService {
    void create(UserRequest request);
    UserResponse getById(Integer id);
    Page<UserResponse> getAllByCriteria(UserCriteria userCriteria);

    void updateUser(Integer id, UserUpdateRequest userUpdateRequest) throws NotFoundException;

    void deleteUsers(Map<Integer, Long> ids);

    UserResponse getByEmail(String email);

    UserResponse getCustomerByEmail(String email);

}
