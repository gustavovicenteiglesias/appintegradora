package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.UserPK;
@Transactional
public interface UserPKDao extends CrudRepository<UserPK, Integer> {

}
