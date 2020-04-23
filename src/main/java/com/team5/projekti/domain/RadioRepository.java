package com.team5.projekti.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RadioRepository extends CrudRepository<Radio, Long> {

	List<Radio> findByQuestion(String question);
    
}
