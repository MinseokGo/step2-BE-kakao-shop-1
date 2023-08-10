package com.example.kakao.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface CartJPARepository extends JpaRepository<Cart, Integer> {
    @Query("select c from Cart c join fetch c.option o join fetch o.product where c.user.id = :userId")
    List<Cart> findAllByUserId(@Param("userId") int userId);

    @Query("select c from Cart c join fetch c.option o join fetch o.product where c.user.id = :userId and c.option.id in :optionIds")
    List<Cart> findAllByUserIdAndOptionIds(int userId, List<Integer> optionIds);

    @Query("select c from Cart c join fetch c.option o join fetch o.product where c.user.id = :userId order by c.option.id asc")
    List<Cart> findByUserIdOrderByOptionIdAsc(int userId);

    @Modifying
    @Transactional
    @Query("delete from Cart c where c.user.id = :userId")
    void deleteByUserId(@Param("userId") int userId);

    @Query("select c from Cart c where c.option.id = :optionId and c.user.id = :userId")
    Optional<Cart> findByOptionIdAndUserId(@Param("optionId") int optionId, @Param("userId") int userId);


}