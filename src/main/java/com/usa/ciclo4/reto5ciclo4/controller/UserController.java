package com.usa.ciclo4.reto5ciclo4.controller;

import com.usa.ciclo4.reto5ciclo4.model.User;
import com.usa.ciclo4.reto5ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }


    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email,password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExists (@PathVariable("email") String email){
        return userService.emailExists(email);
    }

    @GetMapping("/birthday/{month}")
    public List<User> getByMonthBirthDay(@PathVariable("month") String month){
        return userService.getByMonthBirthDay(month);
    }
}