package com.sparta.solo3.repository;

import com.sparta.solo3.model.Ordercase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordercase, Long> {


}
