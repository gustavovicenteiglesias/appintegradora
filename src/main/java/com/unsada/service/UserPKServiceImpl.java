package com.unsada.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.UserPKDao;
import com.unsada.model.UserPK;
@Service
public class UserPKServiceImpl implements UserPKServiceApi {
	@Autowired
	UserPKDao userPKDao;
	@Override
	public <S extends UserPK> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserPK> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserPK> findById(Integer id) {
		// TODO Auto-generated method stub
		return userPKDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return userPKDao.existsById(id);
	}

	@Override
	public Iterable<UserPK> findAll() {
		// TODO Auto-generated method stub
		return userPKDao.findAll();
	}

	@Override
	public Iterable<UserPK> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return userPKDao.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserPK entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends UserPK> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
