package com.becoder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.becoder.entity.User;
import com.becoder.repository.UserRepository;
import com.becoder.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			if (!user.isAccountNonLocked()) {
				userService.unlockAccountIfTimeExpired(user);
			}
			return new CustomUser(user);
		}

	}

}
