package com.github.amangupta00.demo.springboot.controller;

import com.github.amangupta00.demo.springboot.model.User;
import com.github.amangupta00.demo.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
@Slf4j
//@Repository
public class UserController {

    private final UserService userService;

    @GetMapping("/all")

    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
//    @Cacheable(value = "User", key = "#id")
    public User getUserForUserId(@PathVariable("id") Integer userId) {
        log.info("Requested user: {}", userId);
        return userService.getUserForUserId(userId);
    }

    // PUT - update a record of DB with ID
    @PutMapping("/update/{id}")
//    @CachePut(value = "User", key = "#id")
    public int update(@PathVariable("id") int id,@RequestBody User users) throws Exception {
        int rowsAffected = userService.updateById(users);
        if(rowsAffected==0) {
            throw new Exception();
        }
        log.info("Affected user: {}", users.getId());
        return rowsAffected;
    }

    // POST - Insert a record in DB
    @PostMapping("/insert")
//    @CachePut(value = "User",key = "")
    public int insertUserById(@RequestBody User users ) throws Exception {
        int rowsAffected = userService.insert(users);
        if (rowsAffected==0) {
            throw new Exception();
        }
        log.info("Inserted user: {},{}", users.getId(),users.getName());
        return rowsAffected;
    }

    // DELETE - Delete a record in DB by ID
    @DeleteMapping("/delete/{id}")
//    @CacheEvict(value = "User", allEntries = true)
    public int deleteUserById(@PathVariable("id") int id) throws Exception {
        int rowsAffected = userService.deleteById(id);
        if(rowsAffected==0) {
            throw new Exception();
        }
        log.info("Deleted user: {}", id);
        return rowsAffected;
    }
}
