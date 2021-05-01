package com.unsada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.HorariosactividadDao;
import com.unsada.model.Actividad;

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
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Horariosactividad> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Horariosactividad> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<Horariosactividad> findByActividad(Actividad actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horariosactividad> findByActividadAndAula(Integer actividad, Integer aula) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
