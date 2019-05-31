package cn.byau.service;

import cn.byau.dao.UserMapper;
import cn.byau.pojo.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUserNameAndPassword(Map map){
		return userMapper.getUserByUserNameAndPassword(map);				
	}
	public User getUserById(String id){
		return userMapper.getUserById(id);				
	}
	public int update(User user){
		return userMapper.update(user);
	}
}
