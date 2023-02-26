package com.cg.nutritions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritions.entity.Payment;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/addpayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) throws Exception {
		return new ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.CREATED);
	}

	@PutMapping("/addoffer/{discount}")
	public ResponseEntity<Payment> addOffer(@PathVariable Double discount, @RequestBody Payment p)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(paymentService.addOffer(discount, p));
	}

	@PutMapping("/updatepayment/{id}")
	public ResponseEntity<Payment> updatePayment(Payment p,@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(paymentService.updatePayment(p, id));
	}

	@GetMapping("/showpayment")
	public ResponseEntity<List<Payment>> showPayments() {
		return ResponseEntity.ok(paymentService.showPayments());
	}

	@GetMapping("/findpaymentById/{id}")
	public ResponseEntity<Payment> findPaymentById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(paymentService.findPaymentById(id));
	}

}
