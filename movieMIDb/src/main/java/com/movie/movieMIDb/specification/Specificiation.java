package com.movie.movieMIDb.specification;

import com.movie.movieMIDb.model.Person;
import com.movie.movieMIDb.utils.Filter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class Specificiation implements Specification<Person> {

    private Filter filter;

    @Override
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if(filter.getOperation().equalsIgnoreCase(">")){
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(filter.getKey()), filter.getValue().toString()
            );
        }

        return null;
    }
}

