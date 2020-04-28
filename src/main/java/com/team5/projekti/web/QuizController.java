package com.team5.projekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team5.projekti.domain.*;

@Controller
public class QuizController {
	
	@Autowired
	private RadioRepository rqRepository;
	
	@Autowired
	private VastausRepository aRepository;
	
	@RequestMapping(value = {"/login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(value= {"/index", "/"})
	public String index() {
		return "index";
	}
	
	// Rest-rajapinta yksittäiselle Radio-kysymykselle
	@RequestMapping(value="/radio/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Radio> findRadioQuestion(@PathVariable Long id) {
		return rqRepository.findById(id);
	}
	
	// Rest-rajapinta kaikille Radio-kysymyksille
	@RequestMapping(value="/radios", method = RequestMethod.GET)
    public @ResponseBody List<Radio> findAllRadioQuestions() {	
        return (List<Radio>) rqRepository.findAll();
    }
	
	// Add new radio question
    	 @RequestMapping(value = "/addradio")
    	 public String addStudent(Model model){
    		model.addAttribute("radio", new Radio());
    		model.addAttribute("radioQuestions", rqRepository.findAll());
        	return "question";
    	 }     
    
    	// Save new radio question
    	@RequestMapping(value = "/saveradio", method = RequestMethod.POST)
    	 public String save(Radio radio){
        	rqRepository.save(radio);
        	return "redirect:allQuestions";
    	 }    

   	// Delete radio question
    	 @PreAuthorize("hasAuthority('ADMIN')")
    	 @RequestMapping(value = "/deleteradio/{id}", method = RequestMethod.GET)
    	 public String deleteRadio(@PathVariable("id") Long Id, Model model) {
    		rqRepository.deleteById(Id);
        	return "redirect:../allQuestions";
   	 }  
	
	//Rest-rajapinta kaikille vastauksille
	//Vain Admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> findAllAnswers() {	
	     return (List<Vastaus>) aRepository.findAll();
	 }
}
