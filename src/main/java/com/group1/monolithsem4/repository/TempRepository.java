package com.group1.monolithsem4.repository;

import com.group1.monolithsem4.model.TempEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;

@Repository
public interface TempRepository extends JpaRepository<TempEntity, Integer>, JpaSpecificationExecutor<TempEntity> {
    Page<TempEntity> findAll(Specification<TempEntity> tempEntitySpecification, Pageable pageable);

}
