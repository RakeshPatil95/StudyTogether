package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.UserDTO;
import com.app.dto.UserRegResponse;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Override
	public UserRegResponse registerUser(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

}
