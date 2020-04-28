package com.team5.projekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Radio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String question;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Vastaus> answers;*/
	
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
	
	/*public List<Vastaus> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Vastaus> answers) {
		this.answers = answers;
	}*/
	
	@Override
	public String toString() {
		return "Radio [id=" + id + ", question=" + question + "]";
	}

}
