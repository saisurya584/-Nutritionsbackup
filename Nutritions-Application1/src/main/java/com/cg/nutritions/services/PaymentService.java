package com.cg.nutritions.services;

import java.util.List;

import com.cg.nutritions.entity.Payment;
import com.cg.nutritions.exceptions.ResourceNotFoundException;

public interface PaymentService {

	Payment addPayment(Payment p) throws Exception;

	Payment addOffer(Double discount,Payment p) throws ResourceNotFoundException;

	Payment updatePayment(Payment p, Long id) throws ResourceNotFoundException;

	List<Payment> showPayments();

	Payment findPaymentById(Long id) throws ResourceNotFoundException;
}
