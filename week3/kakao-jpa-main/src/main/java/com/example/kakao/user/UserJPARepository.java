package com.example.kakao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.id = :id")
    Optional<User> findById(@Param("id") int id);
}