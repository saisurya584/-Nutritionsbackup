package com.cg.nutritions.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.UserRepository;
import com.cg.nutritions.repository.WeightLogRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	WeightLogRepository weightLogRepository;

	@Override
	public UserTable createUser(UserTable user) throws Exception {
		if (user != null) {
			Optional<UserTable> u = repository.findById(user.getUserId());
			if (u.isPresent()) {
				throw new Exception("User already Exists with id " + user.getUserId());
			}
		}
		return repository.save(user);
	}

//	@Override
//	public UserTable getUser(Long uid) throws ResourceNotFoundException {
//		UserTable u = repository.findById(uid)
//				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + uid));
////		u.setWeightlogs(weightLogRepository.findAll().stream().filter(a -> a.getUser().getUserId() == uid)
////				.collect(Collectors.toList()));
//		return u;

//	}

	@Override
	public UserTable updateUser(UserTable user, Long uid) throws ResourceNotFoundException {
		UserTable u = repository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + uid));

		return repository.save(user);
	}

	@Override
	public void deleteUser(Long id) throws ResourceNotFoundException {
		UserTable u = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + id));
		repository.deleteById(id);

	}

	@Override
	public UserTable findUserById(Long id) throws ResourceNotFoundException {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + id));
	}

	@Override
	public UserTable findUserByEmail(String email) throws ResourceNotFoundException {

		return repository.findUserByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Email : " + email));

	}

	@Override
	public UserTable findUserByName(String name) throws ResourceNotFoundException {
		return repository.findByUserName(name)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Email : " + name));

	}

	@Override
	public UserTable authenticateUser(String userName, String password) throws ResourceNotFoundException {

		return repository.authrnticateUser(userName, password)
				.orElseThrow(() -> new ResourceNotFoundException("Bad or Invalid Credentials"));
	}

	@Override
	public UserTable changePassword(String oldPassword, String newPassword, long id) throws Exception {
		UserTable u = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user password not exists"));
		if (u.getPassword().equals(oldPassword)) {
			u.setPassword(newPassword);
			repository.save(u);
		} else {
			throw new Exception("Old password is not currect");
		}
		return u;
	}

	@Override
	public List<UserTable> showUsers() {
		return repository.findAll();
	}

	@Override
	public List<UserTable> saveUser(UserTable user) {
		UserTable p = repository.save(user);
		if (p != null) {
			return showUsers();
		} else {
			return null;
		}
	}

}
