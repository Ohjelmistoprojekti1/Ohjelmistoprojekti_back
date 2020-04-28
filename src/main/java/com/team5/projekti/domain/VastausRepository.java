package com.team5.projekti.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {

	List<Vastaus> findByAnswer(String answer);
    
}
