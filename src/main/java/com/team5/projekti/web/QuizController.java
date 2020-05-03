package com.team5.projekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team5.projekti.domain.*;

@Controller
public class QuizController {
	
	@Autowired
	private KysymysRepository rqRepository;
	
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
	@RequestMapping(value="/kysymys/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Kysymys> findRadioQuestion(@PathVariable Long id) {
		return rqRepository.findById(id);
	}
	
	// Rest-rajapinta kaikille Radio-kysymyksille
	@RequestMapping(value="/kysymys", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> findAllRadioQuestions() {	
        return (List<Kysymys>) rqRepository.findAll();
    }
	
	// New radio question
	@PreAuthorize("hasAuthority('ADMIN')")
    	@RequestMapping(value = "/kysymys", method = RequestMethod.POST)
    	 Kysymys newKysymys(@RequestBody Kysymys newKysymys){
        	return rqRepository.save(newKysymys);
    	 } 
	
	// save answer
    	@RequestMapping(value = "/vastaus", method = RequestMethod.POST)
    	 Vastaus saveVastaus(@RequestBody Vastaus vastaus){
        	return aRepository.save(vastaus);
    	 } 
    	
    	// Update radio
	@PreAuthorize("hasAuthority('ADMIN')")
    	@RequestMapping(value = "/kysymys/{id}", method = RequestMethod.PUT)
    	  Kysymys replaceKysymys(@RequestBody Kysymys newKysymys, @PathVariable Long id) {

    	    return rqRepository.findById(id)
    	      .map(kysymys -> {
    	        kysymys.setQuestion(newKysymys.getQuestion());
    	        return rqRepository.save(kysymys);
    	      })
    	      .orElseGet(() -> {
    	        newKysymys.setId(id);
    	        return rqRepository.save(newKysymys);
    	      });
    	  }
    	
   	// Delete radio question
    	 @PreAuthorize("hasAuthority('ADMIN')")
    	 @RequestMapping(value = "/kysymys/{id}", method = RequestMethod.DELETE)
    	 void deleteKysymys(@PathVariable("id") Long Id) {
    		rqRepository.deleteById(Id);
   	 }  
	
	
	//Rest-rajapinta kaikille vastauksille
	//Vain Admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> findAllAnswers() {	
	     return (List<Vastaus>) aRepository.findAll();
	 }
	
	//Vain Admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/answerTable", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> findAllAnswers() {	
	     return (List<Vastaus>) aRepository.findAll();
	 }
	 }
}
