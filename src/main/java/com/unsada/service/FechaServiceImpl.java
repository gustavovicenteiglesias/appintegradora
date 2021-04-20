package com.unsada.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.FechaDao;
import com.unsada.model.Fecha;
@Service
public class FechaServiceImpl implements FechaServiceApi {
	@Autowired
	FechaDao fechaDao;
	@Override
	public <S extends Fecha> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Fecha> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Fecha> findById(Integer id) {
		// TODO Auto-generated method stub
		return fechaDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return fechaDao.existsById(id);
	}

	@Override
	public Iterable<Fecha> findAll() {
		// TODO Auto-generated method stub
		return fechaDao.findAll();
	}

	@Override
	public Iterable<Fecha> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return fechaDao.findAllById(ids);
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
	public void delete(Fecha entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Fecha> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
