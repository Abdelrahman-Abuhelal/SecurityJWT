package com.security.user.service;

import com.security.user.entity.User;
import com.security.user.model.UserModel;
import com.security.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;


    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = new ModelMapper();
    }
    public User registerUser(UserModel userModel) {
        User user = modelMapper.map(userModel, User.class);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return user;
    }


}
