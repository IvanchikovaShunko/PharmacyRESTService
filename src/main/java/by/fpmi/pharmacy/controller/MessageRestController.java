package by.fpmi.pharmacy.controller;

import by.fpmi.pharmacy.domain.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageRestController {

	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {
		Message msg = new Message(player, "Hello " + player, "sas");
		return msg;
	}

	
}
