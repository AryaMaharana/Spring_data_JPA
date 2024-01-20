package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.User;

public class QueryUtils {

	public static Specification<User> buildUserSpecification(String firstName, String email, Integer phone) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (Objects.nonNull(email)) {
				predicates.add(criteriaBuilder.equal(root.get("email"), email));
			}
			if (Objects.nonNull(firstName)) {
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
						"%" + firstName.toLowerCase() + "%"));
			}
			if (Objects.nonNull(phone)) {
				predicates.add(criteriaBuilder.equal(root.get("phone"), phone));
			}
			 query.orderBy(criteriaBuilder.desc(root.get("userId")));

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
