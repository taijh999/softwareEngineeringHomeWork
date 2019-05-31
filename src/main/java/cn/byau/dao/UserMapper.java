package cn.byau.dao;

import java.util.Map;

import cn.byau.pojo.User;

public interface UserMapper {
    void delete(Integer id);
    int insert(User user);
    int update(User user);
    User getUserByUserNameAndPassword(Map map);
    User getUserById(String id);
    
}