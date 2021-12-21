package com.hachan.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hachan.assignment.Bean.User;
import com.hachan.assignment.service.UserServiceImpl;


@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@GetMapping("/")
	private String test() {
		return "working";
	}
	@GetMapping("/users")
	private List<User> getAllUsers(){
		System.out.println("working");
		List<User> users = userService.getAllUsers();
		return users;
	}
	@GetMapping("user/{userid}")
	private ResponseEntity<User> getUserById(@PathVariable("userid")  int userId) {
		ResponseEntity<User> u = userService.getUserById(userId);
		return u;
	}
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		User addedUser=userService.addUser(user);
		return addedUser;
	}
	@DeleteMapping("removeUser/{userid}")
	private ResponseEntity<Map<String, Boolean>> removeUser(@PathVariable("userid") int userId){

		return userService.removeUser(userId);
	}
	@PutMapping("updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails){
		
		return userService.updateUser(id,userDetails);
	}
	
	
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}

}
