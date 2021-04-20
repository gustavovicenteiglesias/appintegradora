package com.unsada.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.HorariosactividadDao;
import com.unsada.model.Horariosactividad;
@Service
public class HorariosactividadServiceImpl implements HorariosactividadServiceApi {
	@Autowired
	HorariosactividadDao horariosactividadDao;
	@Override
	public <S extends Horariosactividad> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Horariosactividad> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Horariosactividad> findById(Integer id) {
		// TODO Auto-generated method stub
		return horariosactividadDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return horariosactividadDao.existsById(id);
	}

	@Override
	public Iterable<Horariosactividad> findAll() {
		// TODO Auto-generated method stub
		return horariosactividadDao.findAll();
	}

	@Override
	public Iterable<Horariosactividad> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return horariosactividadDao.findAllById(ids);
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
	public void delete(Horariosactividad entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Horariosactividad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
