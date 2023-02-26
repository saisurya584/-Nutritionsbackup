package com.cg.nutritions.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class WeightLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_fk", referencedColumnName = "userId")
	private UserTable user;

	private double weight;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createdAt;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate updatedAt;

	public WeightLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WeightLog(Long id, UserTable user, double weight, LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.weight = weight;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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
		return "WeightLog [id=" + id + ", user=" + user + ", weight=" + weight + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	
}
