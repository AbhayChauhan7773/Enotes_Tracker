package com.becoder.service;

import com.becoder.entity.User;

public interface UserService {

	 User saveUser(User user);

	boolean existEmailCheck(String email);

	void increaseFailedAttempt(User user);

	void resetFailedAttempts(String email);

	void lockUser(User user);

	boolean unlockAccountIfTimeExpired(User user);

}
