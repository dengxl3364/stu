package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;

@RestController
@RequestMapping("/user")
public class Controller {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/find")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(User user) {
		try {
			userService.insert(user);
			return "success";
		} catch (Exception e) {
			return "insert error";
		}
	}
}
