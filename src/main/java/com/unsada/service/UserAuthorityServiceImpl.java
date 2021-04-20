package com.unsada.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.UserAuthorityDao;
import com.unsada.model.UserAuthority;
@Service
public class UserAuthorityServiceImpl implements UserAuthorityServiceApi {
	@Autowired
	UserAuthorityDao userAuthorityDao;
	@Override
	public <S extends UserAuthority> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserAuthority> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserAuthority> findById(Integer id) {
		// TODO Auto-generated method stub
		return userAuthorityDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return userAuthorityDao.existsById(id);
	}

	@Override
	public Iterable<UserAuthority> findAll() {
		// TODO Auto-generated method stub
		return userAuthorityDao.findAll();
	}

	@Override
	public Iterable<UserAuthority> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return userAuthorityDao.findAllById(ids);
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
	public void delete(UserAuthority entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends UserAuthority> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
