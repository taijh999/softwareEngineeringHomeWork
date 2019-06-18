package cn.byau.service;

import cn.byau.dao.UserDAO;
import cn.byau.entity.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public User getUserByUserNameAndPassword(Map map){
		return userDAO.getUserByUserNameAndPassword(map);				
	}
	public User getUserById(String id){
		return userDAO.getUserById(id);				
	}
	public int update(User user){
		return userDAO.update(user);
	}
}
