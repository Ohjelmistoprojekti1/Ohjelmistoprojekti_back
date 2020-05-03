package com.team5.projekti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.team5.projekti.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProjektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}
	
	
	// POISTA MYÖHEMMIN KAIKKI PAITSI KÄYTTÄJÄT TÄMÄN JÄLKEEN
	// Loggeri
	private static final Logger log = LoggerFactory.getLogger(ProjektiApplication.class);
	
	// Vanhojen esimerkkikysymysten poisto ja uusien lisääminen tietokantaan
	@Bean
	public CommandLineRunner questionDemo(KysymysRepository rqRepository, KayttajaRepository krepository) {
		return (args) -> {
			
			log.info("delete old test data");
			rqRepository.deleteAll();
			log.info("save demo radio questions to db");
			rqRepository.save(new Kysymys("Mitä kuuluu?", "radio"));
			rqRepository.save(new Kysymys("Miten menee?", "open"));
			rqRepository.save(new Kysymys("Moi?", "radio"));
			
			//Salasanat voi hashata BCryptillä ja alempana on 2 esimerkkiä hashatuista salasanoista. Molemmat ovat "salasana123"
			//$2y$12$567/3N/tvuxIR4BKL4dcIeNnL.nB/v0YCP6H5OFKayOiJ/NRH70UW
			//$2y$12$6K6PgixSQvdBBxcehZ6k.e0nJWSGkniZg7BCrlUaqL8O7BvnAlsoK
			Kayttaja userYksi = new Kayttaja("user", "$2y$12$567/3N/tvuxIR4BKL4dcIeNnL.nB/v0YCP6H5OFKayOiJ/NRH70UW", "USER");
			Kayttaja userKaksi = new Kayttaja("admin", "$2y$12$6K6PgixSQvdBBxcehZ6k.e0nJWSGkniZg7BCrlUaqL8O7BvnAlsoK", "ADMIN");
			
			krepository.deleteAll();
			krepository.save(userYksi);
			krepository.save(userKaksi);
		};
	}
	
	

}
