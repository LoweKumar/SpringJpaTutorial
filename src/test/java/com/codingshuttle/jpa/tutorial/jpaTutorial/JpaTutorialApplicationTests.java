package com.codingshuttle.jpa.tutorial.jpaTutorial;

import com.codingshuttle.jpa.tutorial.jpaTutorial.entities.ProductEntity;
import com.codingshuttle.jpa.tutorial.jpaTutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("Amul")
				.title("Amul icecream cake")
				.price(BigDecimal.valueOf(200.00))
				.quantity(10)
				.build();
//		ProductEntity productEntity2 = ProductEntity.builder()
//				.sku("KitKat")
//				.title("KitKat Dark Chocolate")
//				.price(BigDecimal.valueOf(250.00))
//				.quantity(20)
//				.build();

		ProductEntity savedProductEntity = productRepository.save(productEntity);
//		ProductEntity savedProductEntity2 = productRepository.save(productEntity2);
		System.out.println(savedProductEntity);

	}

	@Test
	void getRepository() {
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2025, 1, 1, 0, 0, 0 ));
		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(4, BigDecimal.valueOf(500.00));

		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("KitKat Dark Chocolate", BigDecimal.valueOf(250.00));
		productEntity.ifPresent(System.out::println);
	}


}
