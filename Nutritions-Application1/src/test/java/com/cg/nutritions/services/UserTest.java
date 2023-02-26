package com.cg.nutritions.services;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.nutritions.entity.Gender;
import com.cg.nutritions.entity.Payment;
import com.cg.nutritions.entity.Role;
import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.UserRepository;

@SpringBootTest
public class UserTest {
	@Mock
	UserRepository userRepository; // mock implemented object for IProductDao interface

	@InjectMocks
	UserService service = new UserServiceImpl(); // injecting productDao object into service

	List<UserTable> userlist;
	UserTable u;

	@BeforeEach
	public void beforeTest() {
		userlist = new ArrayList<>();
		u = new UserTable();
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
		userlist.add(u);
	}

	@Test
	@Order(1)
	void testaddUser() {
		System.out.println("Testing Inserting product");

		when(userRepository.save(u)).thenReturn(u);
		when(userRepository.findAll()).thenReturn(userlist);
		List<UserTable> l1 = service.saveUser(u);

		assertTrue(l1.size() > 0);
		assertEquals(1, l1.size());
		assertEquals("Akash", l1.get(0).getUserName());

		verify(userRepository, times(1)).save(u);
		verify(userRepository, times(1)).findAll();

	}

	@Test
	@Order(2)
	void testfindById() throws ResourceNotFoundException {

		Optional<UserTable> op = Optional.of(u);

		when(userRepository.findById(23L)).thenReturn(op);

		UserTable p = service.findUserById(23L);

		assertNotNull(p);
		assertEquals(23L, p.getUserId());
		assertEquals("Akash", p.getUserName());
		// when(userRepository.findById(25L)).thenThrow(ResourceNotFoundException.class);
		assertThrows(ResourceNotFoundException.class, () -> service.findUserById(25L));

		// verify that productDao.findProduct(100) method got executed at least once
		verify(userRepository, times(1)).findById(23L);
	}

	@Test
	@Order(3)
	void testfindByemail() throws ResourceNotFoundException {

		Optional<UserTable> op = Optional.of(u);

		when(userRepository.findUserByEmail("xyz12@gmail.com")).thenReturn(op);

		UserTable p = service.findUserByEmail("xyz12@gmail.com");

		assertNotNull(p);
		assertEquals(23L, p.getUserId());
		assertEquals("Akash", p.getUserName());
		// when(userRepository.findById(25L)).thenThrow(ResourceNotFoundException.class);
		assertThrows(ResourceNotFoundException.class, () -> service.findUserByEmail("xyz@gmail.com"));

		// verify that productDao.findProduct(100) method got executed at least once
		verify(userRepository, times(1)).findUserByEmail("xyz12@gmail.com");
	}

	@Test
	@Order(4)
	void testfindByname() throws ResourceNotFoundException {

		Optional<UserTable> op = Optional.of(u);

		when(userRepository.findByUserName("Akash")).thenReturn(op);

		UserTable p = service.findUserByName("Akash");

		assertNotNull(p);
		assertEquals(23L, p.getUserId());
		assertEquals("Akash", p.getUserName());

		assertThrows(ResourceNotFoundException.class, () -> service.findUserByName("xyz"));

		verify(userRepository, times(1)).findByUserName("Akash");
	}

	@Test
	@Order(5)
	public void showUser() {
		UserTable user = new UserTable();
		List<UserTable> list = new ArrayList<>();
		list.add(user);
		when(userRepository.findAll()).thenReturn(list);
		List<UserTable> expected = userRepository.findAll();
		assertEquals(1, expected.size());

	}

	@Test
	@Order(6)
	public void authenticateUser() throws ResourceNotFoundException {
		Optional<UserTable> op = Optional.of(u);
		when(userRepository.authrnticateUser("Akash", "Abc1234567")).thenReturn(op);
		UserTable p = service.authenticateUser("Akash", "Abc1234567");

		assertNotNull(p);
		assertEquals(23L, p.getUserId());
		assertEquals("Akash", p.getUserName());

		assertThrows(ResourceNotFoundException.class, () -> service.authenticateUser("Akash", "Abc134567"));
		verify(userRepository, times(1)).authrnticateUser("Akash", "Abc1234567");
	}

	@Test
	@Order(7)
	public void changePassword() throws ResourceNotFoundException, Exception {
		Optional<UserTable> op = Optional.of(u);

		when(userRepository.changePassword("Abc1234567", "akash", 23L)).thenReturn(op);

		assertThrows(ResourceNotFoundException.class, () -> service.findUserById(23L));
		assertThrows(Exception.class, () -> service.changePassword("Akash", "hdjhqgfuiqe", 25L));
	}

}
