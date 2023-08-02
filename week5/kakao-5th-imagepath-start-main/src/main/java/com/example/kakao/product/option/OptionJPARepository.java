package com.example.kakao.product.option;

import com.example.kakao.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface OptionJPARepository extends JpaRepository<Option, Integer> {

    @Query("select o from Option o join fetch o.product where o.id = :optionId")
    Optional<Option> findByIdJoinFetch(@Param("optionId") int optionId);

    @Query("select o from Option o where o.product.id = :productId")
    List<Option> findByProductId(@Param("productId") int productId);

    @Query("select o from Option o join fetch o.product where o.product.id = :productId")
    List<Option> findByProductIdJoinFetch(@Param("productId") int productId);
}