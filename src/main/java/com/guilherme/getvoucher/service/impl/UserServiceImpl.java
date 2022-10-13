package com.guilherme.getvoucher.service.impl;

import com.guilherme.getvoucher.model.Role;
import com.guilherme.getvoucher.model.User;
import com.guilherme.getvoucher.repository.RoleRepository;
import com.guilherme.getvoucher.repository.UserRepository;
import com.guilherme.getvoucher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User create(User user) {
        List<Role> roles = roleRepository.saveAll(user.getRoles());

        user.setRoles(roles);
        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return this.userRepository.save(user);
    }

    @Override
    public User findById(String email) {
        return userRepository
                .findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User does not exists!"));
    }
}
