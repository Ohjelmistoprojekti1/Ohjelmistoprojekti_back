package com.team5.projekti.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Radio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String question;
	
	public Radio() {
		this.question = null;
	}
	
	public Radio(String question) {
		super();
		this.question = question;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Radio [id=" + id + ", question=" + question + "]";
	}

}