package com.team5.projekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team5.projekti.domain.*;

@Controller
public class QuizController {
	
	@Autowired
	private KysymysRepository qRepository;
	
	@Autowired
	private VastausRepository aRepository;
	
	@Autowired
	private VastaajaRepository vRepository;
	
	@Autowired
	private VaihtoehtoRepository veRepository;
	
	@RequestMapping(value = {"/login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(value= {"/index", "/"})
	public String index() {
		return "index";
	}
	
	
	//Vain admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= {"/adminpage"})
	public String adminpage() {
		return "adminpage";
	}
	
	// Rest-rajapinta yksittäiselle Radio-kysymykselle
	//@RequestMapping(value="/kysymys/{id}", method=RequestMethod.GET)
	//public @ResponseBody Optional<Kysymys> findRadioQuestion(@PathVariable Long id) {
		//return qRepository.findById(id);
	//}
	
	// Rest-rajapinta kaikille Radio-kysymyksille
	//@RequestMapping(value="/kysymys", method = RequestMethod.GET)
   	//public @ResponseBody List<Kysymys> findAllRadioQuestions() {	
        //return (List<Kysymys>) qRepository.findAll();
    	//}
	
	// Kysymyslista admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= {"/kysymyslista"})
	public String kysymysLista(Model model) {
		model.addAttribute("kysymykset", qRepository.findAll());
		return "kysymyslista";
	}
	
	
	// Lisää kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/lisaakysymys")
	public String addKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("vaihtoehdot", new Vaihtoehto());
		return "lisaakysymys";
	}

	// Tallenna kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	public String tallenna(Kysymys kysymys) {
		qRepository.save(kysymys);
		return "redirect:kysymyslista";
	}

	// Poista kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
	public String poistaKysymys(@PathVariable("id") Long kysymysId, Model model) {
		qRepository.deleteById(kysymysId);
		return "redirect:../kysymyslista";
	}

	// Edit kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
	public String muokkaaKysymys(@PathVariable("id") Long kysymysId, Model model) {
		model.addAttribute("kysymys", qRepository.findById(kysymysId));
		model.addAttribute("vaihtoehdot", veRepository.findAll());
		return "muokkaakysymys";
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
	@RequestMapping(value= {"/vastaajat"})
	public String answerTable(Model model) {
		model.addAttribute("vastaajat", vRepository.findAll());
		return "vastaajat";
	 }
	
	//Vain admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/vastaukset/vastaaja/{id}", method = RequestMethod.GET)
	public String vastauksetPerVastaaja(@PathVariable("id") Long vastaajaId, Model model) {
		model.addAttribute("vastaaja", vRepository.findById(vastaajaId));
		return "vastauksetPerVastaaja";
	}
	
	//Vain admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/vastaukset/kysymys/{id}", method = RequestMethod.GET)
	public String vastauksetPerKysymys(@PathVariable("id") Long kysymysId, Model model) {
		model.addAttribute("kysymys", qRepository.findById(kysymysId));
		return "vastauksetPerKysymys";
	}
	 
}
