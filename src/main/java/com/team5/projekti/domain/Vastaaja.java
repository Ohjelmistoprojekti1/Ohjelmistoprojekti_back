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
public class Vastaaja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vastaaja")
	private List<Vastaus> answers;
	
	public Vastaaja() {
		this.answers = null;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Vastaus> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Vastaus> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Vastaaja [id=" + id + "]";
	}

}
