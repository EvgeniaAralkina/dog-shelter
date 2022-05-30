package com.example.dao;

import com.example.Role;
import com.example.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User get(String name) {
        return userRepository.findByUsername(name);
    }

    public void updateRole(String user, Role role) {
        User user1 = get(user);
        User userToUpdate = userRepository.getOne(user1.getId());
        userToUpdate.getRoles().clear();
        userToUpdate.getRoles().add(role);
        userRepository.save(userToUpdate);
    }
}
