package com.unsada.service;

import org.springframework.data.repository.CrudRepository;

import com.unsada.model.UserAuthority;

public interface UserAuthorityServiceApi extends CrudRepository<UserAuthority, Integer> {

}
