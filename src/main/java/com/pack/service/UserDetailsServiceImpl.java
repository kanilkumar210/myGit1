package com.pack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pack.model.User;
import com.pack.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	User user = null;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		user = userRepository.findByUsername(userName);
		if (user == null || user.isActive() == false)
			throw new UsernameNotFoundException("User 404");
		return new UserDetailsImpl(user);
	}

	public User getUser() {
		System.out.println(user + " In UserDetailsServiceImpl");
		return user;
	}

}