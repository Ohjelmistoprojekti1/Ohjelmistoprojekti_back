package com.team5.projekti.domain;

import org.springframework.data.repository.CrudRepository;

import com.team5.projekti.domain.Kayttaja;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByUsername(String username);
}