package com.devon.demo.repository.specification;

import com.devon.demo.model.Users;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

/**
 * Created by diwenlao on 5/11/17.
 */

public class UsersSpecification implements Specification<Users> {

    private SearchCriteria searchCriteria;

    public UsersSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public javax.persistence.criteria.Predicate toPredicate(javax.persistence.criteria.Root<Users> root, javax.persistence.criteria.CriteriaQuery<?> query, javax.persistence.criteria.CriteriaBuilder builder) {
        if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
            System.out.println("================greater than trigger===============");

            return builder.greaterThanOrEqualTo(
                    root.<Integer>get(searchCriteria.getKey()), (Integer) searchCriteria.getValue());
        } else if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
            System.out.println("================less than trigger===============");
            return builder.lessThanOrEqualTo(
                    root.<Integer>get(searchCriteria.getKey()), (Integer) searchCriteria.getValue());
        } else if (searchCriteria.getOperation().equalsIgnoreCase("=")) {
            System.out.println("================equal than trigger===============");
            return builder.equal(
                    root.<String>get(searchCriteria.getKey()), UUID.fromString((String) searchCriteria.getValue()));


        } else {
            System.out.println("================null trigger===============");

            return null;
        }
//        else if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
//            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
//                return builder.like(
//                        root.<String>get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
//            } else {
//                return builder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
//            }
//        }
        // return null;
    }
}
