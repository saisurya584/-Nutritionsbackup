package com.cg.nutritions.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class UserTable {

	@Id
	//@NotNull(message = "User Id shouldn't be null")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;

	@Column(unique = true)
	@NotEmpty(message = "Name shouldn't be Empty or null ....!!")
	@Size(min = 2, max = 22, message = "Name should be minimum 2 char and max 22 chars")
	@Pattern(regexp = "^[a-zA-Z\\s+]*$", message = "name should have only alphabets")
	private String name;

	@Column(unique = true)
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number of minimum 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	private String contactNo;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dob;
	@Column(unique = true)
	@NotEmpty(message = "Email ID can't be empty!")
	@Size(min = 2, max = 30, message = "Invalid Email ID please enter a vaild email ID")
	@Email(message = "Not the proper Email ID format! enter again")
	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Enumerated(EnumType.STRING)
	private Status status;

	private Double height;

	private Double weight;

	private int workoutTime;

	//@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "Wakeup time shouldn't be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime wakeupTime;

	//@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "sleep time shouldn't be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime sleepTime;

	@NotEmpty(message = "Medical condition data should be added")
	private String medicalCondition;

	private String allergicTool;

	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username should be alphanumeric example :abcd1233")
	@NotEmpty(message = "username shouldn't be null or empty")
	@Size(min = 6, max = 15, message = "username length should me min 6 and and max 15 chars")
	private String userName;

	@Size(min = 7, max = 17, message = "the length of password should be 7 and max to 17 chars")
	private String password;

//	@JsonManagedReference
//	@OneToMany(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "weightlog_fk")
//	private List<WeightLog> weightlogs = new ArrayList<>();
//
//	@OneToMany(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "dietplan_fk")
//	private List<DietPlan> dietPlans = new ArrayList<>();
//
//	@OneToMany(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "nutrition_fk")
//	private List<NutritionPlan> nutritionPlans = new ArrayList<>();

	public UserTable() {
		super();
		// TODO Auto-generated constructor stub
	}

		public UserTable(Long userId,
		@NotEmpty(message = "Name shouldn't be Empty or null ....!!") @Size(min = 2, max = 22, message = "Name should be minimum 2 char and max 22 chars") @Pattern(regexp = "^[a-zA-Z//s]*$", message = "name should have only alphabets") String name,
		@NotEmpty(message = "Phone Number can't be empty!") @Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number of minimum 10 digits") @Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only") String contactNo,
		Gender gender, @NotNull LocalDate dob,
		@NotEmpty(message = "Email ID can't be empty!") @Size(min = 2, max = 30, message = "Invalid Email ID please enter a vaild email ID") @Email(message = "Not the proper Email ID format! enter again") String email,
		Role role, Status status, Double height, Double weight, int workoutTime,
		@NotNull(message = "Wakeup time shouldn't be null") LocalTime wakeupTime,
		@NotNull(message = "sleep time shouldn't be null") LocalTime sleepTime,
		@NotEmpty(message = "Medical condition data should be added") String medicalCondition, String allergicTool,
		@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username should be alphanumeric example :abcd1233") @NotEmpty(message = "username shouldn't be null or empty") @Size(min = 6, max = 15, message = "username length should me min 6 and and max 15 chars") String userName,
		@Size(min = 7, max = 17, message = "the length of password should be 7 and max to 17 chars") String password) {
	super();
	this.userId = userId;
	this.name = name;
	this.contactNo = contactNo;
	this.gender = gender;
	this.dob = dob;
	this.email = email;
	this.role = role;
	this.status = status;
	this.height = height;
	this.weight = weight;
	this.workoutTime = workoutTime;
	this.wakeupTime = wakeupTime;
	this.sleepTime = sleepTime;
	this.medicalCondition = medicalCondition;
	this.allergicTool = allergicTool;
	this.userName = userName;
	this.password = password;
}

		public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getWorkoutTime() {
		return workoutTime;
	}

	public void setWorkoutTime(int workoutTime) {
		this.workoutTime = workoutTime;
	}

	public LocalTime getWakeupTime() {
		return wakeupTime;
	}

	public void setWakeupTime(LocalTime wakeupTime) {
		this.wakeupTime = wakeupTime;
	}

	public LocalTime getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(LocalTime sleepTime) {
		this.sleepTime = sleepTime;
	}

	public String getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public String getAllergicTool() {
		return allergicTool;
	}

	public void setAllergicTool(String allergicTool) {
		this.allergicTool = allergicTool;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<WeightLog> getWeightlogs() {
//		return weightlogs;
//	}
//
//	public void setWeightlogs(List<WeightLog> weightlogs) {
//		this.weightlogs = weightlogs;
//	}

	@Override
	public String toString() {
		return "UserTable [userId=" + userId + ", name=" + name + ", contactNo=" + contactNo + ", gender=" + gender
				+ ", dob=" + dob + ", email=" + email + ", role=" + role + ", status=" + status + ", height=" + height
				+ ", weight=" + weight + ", workoutTime=" + workoutTime + ", wakeupTime=" + wakeupTime + ", sleepTime="
				+ sleepTime + ", medicalCondition=" + medicalCondition + ", allergicTool=" + allergicTool
				+ ", userName=" + userName + ", password=" + password + ", weightlogs=" + "]";
	}
}
