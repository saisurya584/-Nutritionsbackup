package com.cg.nutritions.controller;

import com.cg.nutritions.entity.Gender;
import com.cg.nutritions.entity.Role;
import com.cg.nutritions.entity.Status;
import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.services.UserService;
import com.cg.nutritions.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
     @Autowired
    private UserService user;
    @Test
    void createUser() {
        UserTable us=new UserTable();
        us.setUserId(2L);
        us.setName("saisurya");
        us.setEmail("msurya@gmail.com");
        us.setAllergicTool("weightlifting");
        us.setUserName("saisurya1");
        us.setPassword("Saisurya1@");
        us.setContactNo("9603736869");
        us.setHeight(5.9);
        us.setDob(LocalDate.of(1999, 11, 21));
        us.setGender(Gender.MALE);
        us.setStatus(Status.ACTIVE);
        us.setWeight(40.0);
        us.setRole(Role.CUSTOMER);
        us.setWakeupTime(LocalTime.parse("15:53:16"));
        us.setSleepTime(LocalTime.parse("15:53:16"));
        UserTable u=new UserTable(2L, "saisurya","8978549719",Gender.MALE,LocalDate.of(1999, 11, 21),"msurya@gmail.com",Role.CUSTOMER,Status.ACTIVE,
                 5.9, 40.0, 2, LocalTime.parse("15:53:16"),LocalTime.parse("15:53:16"), "Normal", "weightlifting", "saisurya1",
                 "Saisurya1@");
        assertEquals(u,user.saveUser(us));
    }
}