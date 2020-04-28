package com.team5.projekti.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {

	List<Kysymys> findByQuestion(String question);
    
}
