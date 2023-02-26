package com.cg.nutritions.services;

import java.util.List;

import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.exceptions.ResourceNotFoundException;

public interface UserService {

	UserTable createUser(UserTable user) throws Exception;

	//UserTable getUser(Long uid) throws ResourceNotFoundException;
	List<UserTable> saveUser(UserTable user) ;

	UserTable updateUser(UserTable user, Long uid) throws ResourceNotFoundException;

	void deleteUser(Long id) throws ResourceNotFoundException;

	UserTable findUserById(Long id) throws ResourceNotFoundException;

	UserTable findUserByEmail(String email) throws ResourceNotFoundException;

	UserTable findUserByName(String name) throws ResourceNotFoundException;

	UserTable authenticateUser(String userName, String password) throws ResourceNotFoundException;

	UserTable changePassword(String oldPassword, String newPassword,long id) throws ResourceNotFoundException, Exception;

	List<UserTable> showUsers();

}
