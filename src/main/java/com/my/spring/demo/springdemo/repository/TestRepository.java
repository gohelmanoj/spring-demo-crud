package com.my.spring.demo.springdemo.repository;

import com.my.spring.demo.springdemo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    Optional<Test> findByEmail(String email);
}
