package com.team5.projekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String answer;
	
	@ManyToOne
	@JsonManagedReference
    @JoinColumn(name = "kysymysId")
    private Kysymys kysymys;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "vastaajaId")
	private Vastaaja vastaaja;
	
	public Vastaus() {
		this.answer = null;
		this.kysymys = null;
		this.vastaaja =null;
	}
	
	public Vastaus(String answer, Kysymys kysymys, Vastaaja vastaaja) {
		super();
		this.answer = answer;
		this.kysymys = kysymys;
		this.vastaaja = vastaaja;
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
	
	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	public Vastaaja getVastaaja() {
		return vastaaja;
	}

	public void setVastaaja(Vastaaja vastaaja) {
		this.vastaaja = vastaaja;
	}

	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", answer=" + answer + "]";
	}
	
	
}
