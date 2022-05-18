package com.assignment.multipledatabases.service.user;

import com.assignment.multipledatabases.dao.tenant2.UserRepository;
import com.assignment.multipledatabases.entity.tenant2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl2 implements UserService<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
