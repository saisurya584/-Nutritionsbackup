package com.cg.nutritions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nutritions.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
