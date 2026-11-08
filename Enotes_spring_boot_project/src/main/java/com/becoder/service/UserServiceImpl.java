package com.becoder.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.becoder.entity.User;
import com.becoder.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	private static final int MAX_FAILED_ATTEMPTS = 3;

	private static final long LOCK_DURATION_MINUTES = 15;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setFailedAttempt(0);
		user.setAccountNonLocked(true);
		user.setLockTime(null);
		User newUser = userRepo.save(user);
		return newUser;
	}

	@Override
	public boolean existEmailCheck(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public void increaseFailedAttempt(User user) {
		user.setFailedAttempt(user.getFailedAttempt() + 1);
		userRepo.save(user);
	}

	@Override
	public void resetFailedAttempts(String email) {
		User user = userRepo.findByEmail(email);
		if (user != null && user.getFailedAttempt() > 0) {
			user.setFailedAttempt(0);
			user.setLockTime(null);
			userRepo.save(user);
		}
	}

	@Override
	public void lockUser(User user) {
		user.setAccountNonLocked(false);
		user.setLockTime(LocalDateTime.now());
		userRepo.save(user);
	}

	@Override
	public boolean unlockAccountIfTimeExpired(User user) {
		if (user.getLockTime() == null) {
			return false;
		}

		LocalDateTime unlockTime = user.getLockTime().plusMinutes(LOCK_DURATION_MINUTES);
		if (LocalDateTime.now().isAfter(unlockTime)) {
			user.setAccountNonLocked(true);
			user.setFailedAttempt(0);
			user.setLockTime(null);
			userRepo.save(user);
			return true;
		}
		return false;
	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}

	public int getMaxFailedAttempts() {
		return MAX_FAILED_ATTEMPTS;
	}

}
