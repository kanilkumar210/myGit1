package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String userName);

	@Query(value = "update spring_project.user set is_active=0 where login_id=?1", nativeQuery = true)
	void deleteUserById(long id);

}
