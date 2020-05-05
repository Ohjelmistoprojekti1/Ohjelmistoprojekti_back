package com.team5.projekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String answer;
	
	/*@ManyToOne
	@JoinColumn(name = "id")
	private Vastaaja vastaaja;*/
	
	public Vastaus() {
		this.answer = null;
		/*this.vastaaja= null;*/
	}
	
	public Vastaus(String answer/*, vastaaja vastaaja*/) {
		super();
		this.answer = answer;
		/*this.vastaaja= vastaaja;*/
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", answer=" + answer + "]";
	}
	
	
}
