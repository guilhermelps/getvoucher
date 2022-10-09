package com.guilherme.getvoucher.service.impl;

import com.guilherme.getvoucher.model.User;
import com.guilherme.getvoucher.repository.UserRepository;
import com.guilherme.getvoucher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }
}
