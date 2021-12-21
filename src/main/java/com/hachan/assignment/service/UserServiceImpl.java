package com.hachan.assignment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hachan.assignment.Bean.User;
import com.hachan.assignment.ecception.UserNotFoundEcception;
import com.hachan.assignment.repository.UserRepository;


@Component("userService")
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		return users;
	}
	
	
	
	public ResponseEntity<User> getUserById(int userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundEcception("Employee not exist with id :" + userId));
		return ResponseEntity.ok(user);
	}

	
	public User addUser(User u) {
		User addedUser= userRepository.save(u);
		return addedUser;
	}



	public ResponseEntity<Map<String, Boolean>> removeUser(int userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundEcception("Employee not exist with id :" + userId));
//		if(user!=null) {
//			userRepository.delete(user);
//			return "success";
//		}
//		return "user not found";
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}



	public ResponseEntity<User> updateUser(int id, User userDetails) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundEcception("Employee not exist with id :" + id));
		
		user.setName(userDetails.getName());
		user.setAddress(userDetails.getAddress());
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	



	
}
