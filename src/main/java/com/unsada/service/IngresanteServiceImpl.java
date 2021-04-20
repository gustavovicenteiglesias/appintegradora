package com.unsada.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.IngresanteDao;
import com.unsada.model.Ingresante;
@Service
public class IngresanteServiceImpl implements IngresanteServiceApi {
	@Autowired
	IngresanteDao ingresanteDao;
	@Override
	public <S extends Ingresante> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ingresante> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ingresante> findById(Integer id) {
		// TODO Auto-generated method stub
		return ingresanteDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return ingresanteDao.existsById(id);
	}

	@Override
	public Iterable<Ingresante> findAll() {
		// TODO Auto-generated method stub
		return ingresanteDao.findAll();
	}

	@Override
	public Iterable<Ingresante> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return ingresanteDao.findAllById(ids);
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
	public void delete(Ingresante entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Ingresante> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
