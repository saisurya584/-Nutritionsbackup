package com.cg.nutritions.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DietPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@JsonBackReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_fk", referencedColumnName = "userId")
	private UserTable user;
	private String foodType;
	private String excercise;
	private double proteinRatio;
	private double fatRatio;
	private double carbsRatio;
	private double total;
	private String slots;
	public DietPlan() {
		super();
		
	}
	public DietPlan(Long id, UserTable user, String foodType, String excercise, double proteinRatio, double fatRatio,
			double carbsRatio, double total, String slots) {
		super();
		this.id = id;
		this.user = user;
		this.foodType = foodType;
		this.excercise = excercise;
		this.proteinRatio = proteinRatio;
		this.fatRatio = fatRatio;
		this.carbsRatio = carbsRatio;
		this.total = total;
		this.slots = slots;
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
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getExcercise() {
		return excercise;
	}
	public void setExcercise(String excercise) {
		this.excercise = excercise;
	}
	public double getProteinRatio() {
		return proteinRatio;
	}
	public void setProteinRatio(double proteinRatio) {
		this.proteinRatio = proteinRatio;
	}
	public double getFatRatio() {
		return fatRatio;
	}
	public void setFatRatio(double fatRatio) {
		this.fatRatio = fatRatio;
	}
	public double getCarbsRatio() {
		return carbsRatio;
	}
	public void setCarbsRatio(double carbsRatio) {
		this.carbsRatio = carbsRatio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	@Override
	public String toString() {
		return "DietPlan [id=" + id + ", user=" + user + ", foodType=" + foodType + ", excercise=" + excercise
				+ ", proteinRatio=" + proteinRatio + ", fatRatio=" + fatRatio + ", carbsRatio=" + carbsRatio
				+ ", total=" + total + ", slots=" + slots + "]";
	}
	
	

}
