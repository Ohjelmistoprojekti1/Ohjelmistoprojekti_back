package com.team5.projekti.webcontrol;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team5.projekti.domain.Radio;
import com.team5.projekti.domain.RadioRepository;

@Controller
public class QuizController {
	
	@Autowired
	private RadioRepository rqRepository;
	
	// Rest-rajapinta yksittäiselle Radio-kysymykselle
	@RequestMapping(value="/radio/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Radio> findRadioQuestion(@PathVariable Long id) {
		return rqRepository.findById(id);
	}
	
	@RequestMapping(value="/test/radioquestions", method=RequestMethod.GET)
	public String findAllRadioQuestionsTEST(Model model) {
		model.addAttribute("radioQuestions", rqRepository.findAll());
		return "allQuestions";
	}
	
	@RequestMapping(value="/test/radioquestion/{id}", method=RequestMethod.GET)
	public String findRadioQuestionTEST(@PathVariable Long id, Model model) {
		model.addAttribute("radioQuestion", rqRepository.findById(id));
		return "question";
	}
	
}