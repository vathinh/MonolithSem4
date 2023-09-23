package com.group1.monolithsem4.service.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PredicateBuilder<T> {

    private final CriteriaBuilder criteriaBuilder;
    private final Root<T> root;
    private final List<Predicate> predicates = new ArrayList<>();

    private PredicateBuilder(CriteriaBuilder criteriaBuilder, Root<T> root) {
        this.criteriaBuilder = criteriaBuilder;
        this.root = root;
    }

    public static <T> PredicateBuilder<T> create(CriteriaBuilder criteriaBuilder, Root<T> root) {
        return new PredicateBuilder<>(criteriaBuilder, root);
    }

    public PredicateBuilder<T> add(Predicate predicate) {
        predicates.add(predicate);
        return this;
    }

    public PredicateBuilder<T> addIf(boolean condition, Consumer<PredicateBuilder<T>> predicateConsumer) {
        if (condition) {
            predicateConsumer.accept(this);
        }
        return this;
    }

    public Predicate build() {
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
