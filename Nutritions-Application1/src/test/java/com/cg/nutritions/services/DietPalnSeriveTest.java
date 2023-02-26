package com.cg.nutritions.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.nutritions.entity.DietPlan;
import com.cg.nutritions.entity.Gender;
import com.cg.nutritions.entity.Role;
import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.DietPlanRepository;

@SpringBootTest
class DietPalnSeriveTest {

	@Autowired
	private DietPalnSerive dietPalnSerive;
	
	@Autowired
	private DietPlanRepository dietPlanRepository;
	@Test
	void testCreateDietPlan() {
		UserTable u = new UserTable();
		u.setUserId(4L);
		u.setUserName("Akash");
		u.setAllergicTool("xyz");
		u.setContactNo("9900123100");
		u.setDob(LocalDate.of(1999, 11, 21));
		u.setEmail("xyz12@gmail.com");
		u.setGender(Gender.MALE);
		u.setHeight(5.8);
		u.setMedicalCondition("Normal");
		u.setName("AkashKumar");
		u.setPassword("Abc1234567");
		u.setRole(Role.ADMIN);
		u.setSleepTime(LocalTime.parse("15:53:16"));
		u.setWakeupTime(LocalTime.parse("06:53:16"));
		u.setWeight(73.5);
		u.setWorkoutTime(2);
		DietPlan d= new DietPlan(4L, null, "Normal", "Press", 23.4, 34.6, 45.7, 344.9, "xyz");
		assertEquals(d, dietPalnSerive.createDietPlan(d));
		dietPlanRepository.delete(d);
		
	}

	@Test
	void testGetDietPlan() throws ResourceNotFoundException {
		UserTable u = new UserTable();
		u.setUserId(23L);
		u.setUserName("Akash");
		u.setAllergicTool("xyz");
		u.setContactNo("9900123100");
		u.setDob(LocalDate.of(1999, 11, 21));
		u.setEmail("xyz12@gmail.com");
		u.setGender(Gender.MALE);
		u.setHeight(5.8);
		u.setMedicalCondition("Normal");
		u.setName("AkashKumar");
		u.setPassword("Abc1234567");
		u.setRole(Role.ADMIN);
		u.setSleepTime(LocalTime.parse("15:53:16"));
		u.setWakeupTime(LocalTime.parse("06:53:16"));
		u.setWeight(73.5);
		u.setWorkoutTime(2);
		DietPlan d= new DietPlan(23L, null, "Normal", "Press", 23.4, 34.6, 45.7, 344.9, "xyz");
		dietPlanRepository.save(d);
		assertEquals(d,dietPalnSerive.getDietPlan(d.getId()));
		//dietPlanRepository.delete(d);
	}


	@Test
	void testDeleteDietPlan() throws ResourceNotFoundException {
		
		UserTable u = new UserTable();
		u.setUserId(23L);
		u.setUserName("Akash");
		u.setAllergicTool("xyz");
		u.setContactNo("9900123100");
		u.setDob(LocalDate.of(1999, 11, 21));
		u.setEmail("xyz12@gmail.com");
		u.setGender(Gender.MALE);
		u.setHeight(5.8);
		u.setMedicalCondition("Normal");
		u.setName("AkashKumar");
		u.setPassword("Abc1234567");
		u.setRole(Role.ADMIN);
		u.setSleepTime(LocalTime.parse("15:53:16"));
		u.setWakeupTime(LocalTime.parse("06:53:16"));
		u.setWeight(73.5);
		u.setWorkoutTime(2);
		DietPlan d= new DietPlan(23L, null, "Normal", "Press", 23.4, 34.6, 45.7, 344.9, "xyz");
		dietPlanRepository.save(d);
		assertEquals(true, dietPalnSerive.deleteDietPlan(d.getId()));
		
		
	}

	@Test
	void testShowAllDietPlan() {
		DietPlan d= new DietPlan(23L, null, "Normal", "Press", 23.4, 34.6, 45.7, 344.9, "xyz");
		dietPlanRepository.save(d);
		assertNotNull(dietPalnSerive.showAllDietPlan());
		
	}

}
