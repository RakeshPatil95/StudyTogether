package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import com.app.dto.ProductSearchRequest;
import com.app.pojos.Product;

@SpringBootTest
class TestCriteriaQuery {
	@Autowired
	private EntityManager mgr;

	@Test
	void test() {
		assertNotNull(mgr);
		ProductSearchRequest request = new ProductSearchRequest();
		request.setName("mango");
		request.setExpiresOn(LocalDate.of(2020, 1, 15));
		request.setPrice(200);
		CriteriaBuilder criteriaBuilder = mgr.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		// Adding search criteria's for query using CriteriaBuilder
		List<Predicate> searchCriterias = new ArrayList<>();
		if (StringUtils.hasLength(request.getName()))
			searchCriterias.add(criteriaBuilder.equal(root.get("name"), request.getName()));
		criteriaQuery.select(root)
				.where(criteriaBuilder.and(searchCriterias.toArray(new Predicate[searchCriterias.size()])));
		 assertEquals(2,mgr.createQuery(criteriaQuery).getSingleResult().getProductId());

	}

}
