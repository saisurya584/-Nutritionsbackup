package com.cg.nutritions.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping({"/user/create-user"})
	public ResponseEntity<UserTable> createUser(@RequestBody @Valid UserTable user) throws Exception {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	};

	
//	@GetMapping({"/get-user-by-id/{uid}" })
//	public ResponseEntity<UserTable> getUser(@PathVariable Long uid) throws ResourceNotFoundException {
//		return ResponseEntity.ok(userService.getUser(uid));
//	}

	@PutMapping({ "/updateUserById/{uid}"})
	public ResponseEntity<UserTable> updateUser(@RequestBody @Valid UserTable user, @PathVariable Long uid)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.updateUser(user, uid));
	}

	@DeleteMapping({"/deleteUserById/{id}"})
	public ResponseEntity<?> deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
		userService.deleteUser(id);
		return ResponseEntity.ok("Dleted user ");

	}

	@GetMapping("/findUserById/{id}")
	public ResponseEntity<?> findUserById(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<UserTable>(userService.findUserById(id), HttpStatus.OK);
	}

	@GetMapping({"/findUserByEmail/{email}"})
	public ResponseEntity<?> findUserByEmail(@PathVariable String email) throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.findUserByEmail(email));
	}

	@GetMapping({"/findUserByName/{name}"})
	public ResponseEntity<?> findUserByName(@PathVariable String name) throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.findUserByName(name));
	}

	@GetMapping("/authenticateUser/{userName}/{password}")
	public ResponseEntity<?> authenticateUser(@PathVariable String userName, @PathVariable String password)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.authenticateUser(userName, password));
	}

	@PutMapping({"changePassword/{oldPassword}/{newPassword}/{userId}"})
	public ResponseEntity<UserTable> changePassword(@PathVariable String oldPassword, @PathVariable String newPassword,
			@PathVariable Long userId) throws Exception {
		return ResponseEntity.ok(userService.changePassword(oldPassword, newPassword, userId));

	}

	@GetMapping("/showAllUsers")
	public ResponseEntity<List<UserTable>> showUsers() {
		return ResponseEntity.ok(userService.showUsers());

	}

}
