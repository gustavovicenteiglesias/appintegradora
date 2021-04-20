package com.unsada.service;

import org.springframework.data.repository.CrudRepository;

import com.unsada.model.User;

public interface UserServiceApi extends CrudRepository<User, Integer> {

}
