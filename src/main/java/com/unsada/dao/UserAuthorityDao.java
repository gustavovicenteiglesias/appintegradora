package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.UserAuthority;
@Transactional
public interface UserAuthorityDao extends CrudRepository<UserAuthority, Integer> {

}
