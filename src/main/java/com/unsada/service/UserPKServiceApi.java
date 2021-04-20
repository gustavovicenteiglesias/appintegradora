package com.unsada.service;

import org.springframework.data.repository.CrudRepository;

import com.unsada.model.UserPK;

public interface UserPKServiceApi extends CrudRepository<UserPK, Integer> {

}
