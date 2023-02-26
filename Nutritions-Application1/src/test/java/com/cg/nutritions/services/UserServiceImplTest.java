package com.cg.nutritions.services;

import com.cg.nutritions.entity.DietPlan;
import com.cg.nutritions.entity.Gender;
import com.cg.nutritions.entity.Role;
import com.cg.nutritions.entity.UserTable;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void createUser() {
        UserTable u=new UserTable();
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
      //  assertEquals(d, dietPalnSerive.createDietPlan(d));
    }
}