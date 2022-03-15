package com.github.amangupta00.demo.springboot.service;

import com.github.amangupta00.demo.springboot.dao.UserDao;
import com.github.amangupta00.demo.springboot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User getUserForUserId(int userId) {
        return userDao.getUserForUserId(userId);
    }

    public List<User> findAll() {
        return userDao.getAllUsers();
    }

    public int insert(User user){
        return userDao.insert(user);
    }

    public int updateById(User user){
        return userDao.update(user);
    }

    public int deleteById(int userId){
        return userDao.deleteById(userId);
    }
}
