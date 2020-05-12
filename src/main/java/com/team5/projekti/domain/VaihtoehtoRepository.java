package com.team5.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaihtoehtoRepository extends CrudRepository<Vaihtoehto, Long>{
	List<Vaihtoehto> findByName(String teksti);
}
