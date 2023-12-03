package com.nhom_6.duan_1.repository;

import com.nhom_6.duan_1.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT DISTINCT p FROM Product p " +
            "JOIN p.productDetails pd " +
            "WHERE pd.color.id = :id")
    List<Product> findAllByColor_Id(@Param("id") Long id);
}
