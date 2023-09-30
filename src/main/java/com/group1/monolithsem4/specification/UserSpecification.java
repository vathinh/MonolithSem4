package com.group1.monolithsem4.specification;

import com.group1.monolithsem4.dto.user.UserCriteria;
import com.group1.monolithsem4.model.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserSpecification {

    public Specification<UserEntity> getUserCriteria(UserCriteria userCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if(userCriteria.getUserType() != null && !userCriteria.getUserType().isEmpty()) {
                predicateList.add(criteriaBuilder.equal(root.get("userType"), userCriteria.getUserType()));
            }
            if(userCriteria.getFirstName() != null && !userCriteria.getFirstName().isEmpty()) {
                predicateList.add(criteriaBuilder.equal(root.get("firstName"), userCriteria.getFirstName()));
            }
            if(userCriteria.getLastName() != null && !userCriteria.getLastName().isEmpty()) {
                predicateList.add(criteriaBuilder.equal(root.get("lastName"), userCriteria.getLastName()));
            }
            if(userCriteria.getEmail() != null && !userCriteria.getEmail().isEmpty()) {
                predicateList.add(criteriaBuilder.equal(root.get("email"), userCriteria.getEmail()));
            }
            query.orderBy(criteriaBuilder.desc(root.get("id")));

            predicateList.add(criteriaBuilder.equal(root.get("deleteFlag"), false));

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }
}
