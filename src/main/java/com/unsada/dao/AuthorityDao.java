package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Authority;
@Transactional
public interface AuthorityDao extends CrudRepository<Authority, Integer> {

}
