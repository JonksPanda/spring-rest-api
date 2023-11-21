package com.jonks.userapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jonks.userapi.api.models.User;

@Service
public class UserService {
    private static List<User> userList = new ArrayList<>();
    
    private static int next_id = 0;

    public static User newUser(String name, int age, String email) {
        User user = new User(next_id, name, age, email);
        addNewUser(user);

        return user;
    }

    private static void addNewUser(User user) {
        UserService.userList.add(user);
        UserService.next_id += 1;
    }
}
