package com.team5.projekti.webcontrol;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team5.projekti.domain.Radio;
import com.team5.projekti.domain.RadioRepository;

@RestController
public class QuizzController {
	
	@Autowired
	private RadioRepository rqRepository;
	
	
	@RequestMapping(value="/radio/{id}", method=RequestMethod.GET)
	public Optional<Radio> findRadioQuestion(@PathVariable Long id) {
		return rqRepository.findById(id);
	}
	
}