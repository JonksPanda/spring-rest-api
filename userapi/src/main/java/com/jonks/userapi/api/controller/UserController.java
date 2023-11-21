package com.jonks.userapi.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonks.userapi.api.models.User;
import com.jonks.userapi.service.UserService;

@RestController
public class UserController {

    // Adds new user from POST-request with JSON
    @PostMapping(value = "/newUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> newUser(@RequestBody String jsonInput)
            throws JsonMappingException, JsonProcessingException {
        Map<String, Object> userData = new ObjectMapper().readValue(jsonInput, HashMap.class);

        String name = userData.get("name").toString();
        int age = Integer.parseInt(userData.get("age").toString());
        String email = userData.get("email").toString();

        User user = UserService.newUser(name, age, email);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}