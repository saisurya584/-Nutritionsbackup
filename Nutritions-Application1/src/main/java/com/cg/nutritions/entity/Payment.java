package com.cg.nutritions.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "payment_details")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pymentId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id_fk", referencedColumnName = "userId")
	private UserTable user_id;

	private Long planId;

	private double payment;

	private double discount;

	private LocalDate createdAt;

	private LocalDate updatedAt;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long pymentId, UserTable user_id, Long planId, double payment, double discount, LocalDate createdAt,
			LocalDate updatedAt) {
		super();
		this.pymentId = pymentId;
		this.user_id = user_id;
		this.planId = planId;
		this.payment = payment;
		this.discount = discount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getPymentId() {
		return pymentId;
	}

	public void setPymentId(Long pymentId) {
		this.pymentId = pymentId;
	}

	public UserTable getUser_id() {
		return user_id;
	}

	public void setUser_id(UserTable user_id) {
		this.user_id = user_id;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Payment [pymentId=" + pymentId + ", user_id=" + user_id + ", planId=" + planId + ", payment=" + payment
				+ ", discount=" + discount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
