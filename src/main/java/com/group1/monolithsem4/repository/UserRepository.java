package com.group1.monolithsem4.repository;

import com.group1.monolithsem4.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
    Page<UserEntity> findAll(Specification<UserEntity> specification,Pageable pageable);

    Optional<UserEntity> findByIdAndDeleteFlag(Integer id, boolean b);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByKeycloakId(String keycloakId);

}
