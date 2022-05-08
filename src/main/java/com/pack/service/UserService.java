package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.User;
import com.pack.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public List<User> getUser() {
		return repo.findAll();
	}

	public User resetPassword(String pass, String confirmPass, long login_id) {
		User user = null;
		if (pass.equals(confirmPass)) {
			user = repo.getById(login_id);
			if (user != null) {
				user.setPassword(pass);
				user.setStatus("NFL");
				return repo.save(user);
			}
		}
		return user;
	}

	public User getUser(long id) {
		return repo.getById(id);
	}

	public void updateUser(User userBean) {
		User user = repo.getById(userBean.getLogin_id());
		user.setAddress(userBean.getAddress());
		user.setDepartment(userBean.getDepartment());
		user.setMobileNumber(userBean.getMobileNumber());
		repo.save(user);
	}

	public void deleteUser(long id) {
		User user = repo.findById(id).get();
		user.setActive(false);
		repo.save(user);
	}

	public User addUserDetails(User userBean) {
		userBean.setActive(true);
		userBean.setRoles("ROLE_USER");
		userBean.setStatus("F");
		return repo.save(userBean);
	}
}
