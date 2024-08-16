package com.bjorn.boltmart.Service;

import com.bjorn.boltmart.Repository.UserRepository;
import com.bjorn.boltmart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }


}
