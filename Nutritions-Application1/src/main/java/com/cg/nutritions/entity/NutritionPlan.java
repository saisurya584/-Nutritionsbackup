package com.cg.nutritions.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class NutritionPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long planId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_details_fk",referencedColumnName = "userId")
	private UserTable user;

	@NotEmpty(message = "Plan name shouldn't be null or empty !!")
	private String planName;

	private String description;

	private LocalDate createdAt;

	private LocalDate updatedAt;

	private Double price;

	public NutritionPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NutritionPlan(Long planId, UserTable user,
			@NotEmpty(message = "Plan name shouldn't be null or empty !!") String planName, String description,
			LocalDate createdAt, LocalDate updatedAt, Double price) {
		super();
		this.planId = planId;
		this.user = user;
		this.planName = planName;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.price = price;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NutritionPlan [planId=" + planId + ", user=" + user + ", planName=" + planName + ", description="
				+ description + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", price=" + price + "]";
	}

}
