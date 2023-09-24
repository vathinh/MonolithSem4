package com.group1.monolithsem4.specification;

import com.group1.monolithsem4.dto.temp.TempCriteria;
import com.group1.monolithsem4.model.TempEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TempSpecification {

    public Specification<TempEntity> getTempCriteria(TempCriteria tempCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(tempCriteria.getTempDes() != null && !tempCriteria.getTempDes().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("tempDes"), tempCriteria.getTempDes()));
            }
            if(tempCriteria.getTempName() != null && !tempCriteria.getTempName().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("tempName"), tempCriteria.getTempName()));
            }

            query.orderBy(criteriaBuilder.desc(root.get("id")));

            predicates.add(criteriaBuilder.equal(root.get("deleteFlag"), false));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
