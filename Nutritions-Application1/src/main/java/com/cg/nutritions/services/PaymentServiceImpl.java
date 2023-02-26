package com.cg.nutritions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritions.entity.Payment;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment p) throws Exception {
		return paymentRepository.save(p);
	}

	@Override
	public Payment addOffer(Double discount, Payment p) throws ResourceNotFoundException {
		Payment p1 = paymentRepository.findById(p.getPymentId())
				.orElseThrow(() -> new ResourceNotFoundException("Payment doesn't exists " + p.getPymentId()));

		p.setDiscount(discount);
		return paymentRepository.save(p);
	}

	@Override
	public Payment updatePayment(Payment p, Long id) throws ResourceNotFoundException {
		Payment p1 = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment doesn't exists " + id));
		

		return paymentRepository.save(p);
	}

	@Override
	public List<Payment> showPayments() {

		return paymentRepository.findAll();
	}

	@Override
	public Payment findPaymentById(Long id) throws ResourceNotFoundException {

		return paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment doesn't exists " + id));
	}

}
