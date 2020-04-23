package com.team5.projekti.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

	@Service
	public class UserDetailServiceImpl implements UserDetailsService {
		private final KayttajaRepository repository;
	@Autowired
	public UserDetailServiceImpl(KayttajaRepository kayttajaRepository) {
		this.repository = kayttajaRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws
		
		UsernameNotFoundException {
		Kayttaja curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
		curruser.getPasswordHash(),
		
		AuthorityUtils.createAuthorityList(curruser.getRole()));
		
	return user;
	}
	}