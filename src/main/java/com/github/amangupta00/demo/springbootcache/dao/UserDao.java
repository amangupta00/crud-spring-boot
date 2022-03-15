package com.github.amangupta00.demo.springboot.dao;

import com.github.amangupta00.demo.springboot.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    @Select("select * from Users")
    public List<User> getAllUsers();

    @Select("select * from Users where id = #{id}")
    public User getUserForUserId(Integer userId);

    @Insert("insert into Users(name,email,phone) values (#{name},#{email},#{phone})")
    public int insert(User users);

    @Update("update Users set name=#{name},email=#{email},phone=#{phone} where id=#{id}")
    public int update(User users);

    @Delete("delete from Users where id=#{id}")
    public int deleteById(int id);
}
