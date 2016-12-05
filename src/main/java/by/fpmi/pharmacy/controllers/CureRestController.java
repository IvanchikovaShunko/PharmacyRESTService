package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.User;
import by.fpmi.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CureRestController {

	@Autowired
	private UserService userService;


	@RequestMapping("/user/{userId}")
	public User user(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		return user;
	}

	
}
