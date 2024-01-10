package com.personaleconomy.personeleconomy.service;

import com.personaleconomy.personeleconomy.entity.Customer;
import com.personaleconomy.personeleconomy.entity.User;
import com.personaleconomy.personeleconomy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
