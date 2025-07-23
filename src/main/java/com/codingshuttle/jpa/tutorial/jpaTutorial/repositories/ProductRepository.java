package com.codingshuttle.jpa.tutorial.jpaTutorial.repositories;

import com.codingshuttle.jpa.tutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
    List<ProductEntity> findByOrderByPrice ();

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int i, BigDecimal bigDecimal);

//    Optional<ProductEntity> findByTitleAndPrice(String peps, BigDecimal bigDecimal);

    @Query("select e from ProductEntity e where e.title=:title and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
