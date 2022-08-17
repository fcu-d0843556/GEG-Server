package com.controller;

import com.exception.BaseException;
import com.service.UserService;
import com.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/getAllUser")
    public ResponseEntity<Object> getAllUser() {
        System.out.println("getAllUser");
        ResponseEntity<Object> response;
        try {
            List<User> result = userService.findAll();
            response = new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            response = new ResponseEntity<>(error.getMessage(), HttpStatus.FORBIDDEN);
        }

        return response;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        // System.out.println("createUser : ");
        // System.out.println("name : " + name);
        // System.out.println("username : " + username);
        // System.out.println("password : " + password);
        ResponseEntity<Object> response;
        try {
            Object result = userService.createUser(name,username,password);
            response = new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception error) {
            response = new ResponseEntity<>( ((BaseException)error).toJson(), HttpStatus.FORBIDDEN);
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println("login : ");
        // System.out.println("username : " + username);
        // System.out.println("password : " + password);
        ResponseEntity<Object> response;
        Object result = userService.login(username,password);
        response = new ResponseEntity<>(result, HttpStatus.OK);
        // System.out.println("response : " + response);
        return response;
    }

    @GetMapping("/getUserPoints")
    public ResponseEntity<Object> getUserPoints(@RequestParam("username") String username){
        System.out.println("getUserPoints : ");
        System.out.println("username : " + username);
        Object result = userService.getUserPoints(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllUsersPoints")
    public ResponseEntity<Object> getAllUsersPoints(){
        System.out.println("getAllUsersPoints");
        Object result = userService.getAllUsersPoints();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
