package com.team5.projekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String question;
	private String type;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Vastaus> answers;
	
	public Kysymys() {
		this.question = null;
	}
	
	public Kysymys(String question, String type) {
		super();
		this.question = question;
		this.type = type;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public List<Vastaus> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Vastaus> answers) {
		this.answers = answers;
	}
	
	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", question=" + question + ", type=" + type + "]";
	}

}
