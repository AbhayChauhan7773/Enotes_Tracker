package com.becoder.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.becoder.entity.User;
import com.becoder.repository.UserRepository;
import com.becoder.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserServiceImpl userService;

	public CustomAuthenticationFailureHandler() {
		setDefaultFailureUrl("/signin?error");
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String username = request.getParameter("username");
		User user = userRepo.findByEmail(username);

		if (user != null) {
			if (!user.isAccountNonLocked()) {
				if (userService.unlockAccountIfTimeExpired(user)) {
					exception = new LockedException("Your account has been unlocked. Please try logging in again.");
				} else {
					exception = new LockedException("Your account is locked for 15 minutes due to failed login attempts.");
				}
			} else {
				userService.increaseFailedAttempt(user);
				if (user.getFailedAttempt() >= userService.getMaxFailedAttempts()) {
					userService.lockUser(user);
					exception = new LockedException("Your account is locked for 15 minutes due to 3 failed login attempts.");
				}
			}
		}

		super.onAuthenticationFailure(request, response, exception);
	}
}
