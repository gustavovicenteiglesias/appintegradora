package com.unsada.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unsada.dao.AulaDao;
import com.unsada.model.Aula;
@Service 
public class AulaServiceImpl implements AulaServiceApi {
	@Autowired
	AulaDao aulaDao;
	@Override
	public <S extends Aula> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Aula> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Aula> findById(Integer id) {
		// TODO Auto-generated method stub
		return aulaDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return aulaDao.existsById(id);
	}

	@Override
	public Iterable<Aula> findAll() {
		// TODO Auto-generated method stub
		return aulaDao.findAll();
	}

	@Override
	public Iterable<Aula> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return aulaDao.findAllById(ids);
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
	public void delete(Aula entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Aula> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
