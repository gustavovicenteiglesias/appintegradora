package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.User;
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

}
