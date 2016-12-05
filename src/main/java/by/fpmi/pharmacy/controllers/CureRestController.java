package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.Question;
import by.fpmi.pharmacy.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CureRestController {

	@Autowired
	private QuestionService questionService;


	@RequestMapping("/question/{questionID}")
	public Question question(@PathVariable long questionID) {
		Question question = questionService.getQuestion(questionID);
		return question;
	}

	
}
