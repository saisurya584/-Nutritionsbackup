package com.cg.nutritions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cg.nutritions.entity.UserTable;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
	
	@Query(value = "Select o from UserTable o where o.email=?1")
	Optional<UserTable> findUserByEmail(String email);

	@Query(value = "Select o from UserTable o where o.name=?1")
	Optional<UserTable> findByUserName(String n);

	@Query(value = "Select o from UserTable o where o.userName=?1 and o.password=?2")
	Optional<UserTable> authrnticateUser(String userName, String password);

	@Query(value = "select o from UserTable o where o.password=?1")
	Optional<UserTable> changePassword(String oldPassword, String newPassword, long id);

}
