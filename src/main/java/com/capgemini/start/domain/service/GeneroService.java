package com.capgemini.start.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.repository.GeneroRepository;
import com.capgemini.start.domain.service.exceptions.ObjectAlreadyExistsException;
import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

@Service
public class GeneroService extends AbstractService<Genero, Integer>{
	
	@Autowired
	private GeneroRepository repository;

	@Override
	protected JpaRepository<Genero, Integer> getRepository() {
		return this.repository;
	}
	
	@Override
	public List<Genero> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Genero findById(Integer id){
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Gênero não encontrado"));
	}
	
	@Override
	public Genero insert(Genero genero) {
		if (this.repository.existsByGeneroIgnoreCase(genero.getGenero())){
			throw new ObjectAlreadyExistsException("Já existe um gênero com esta descrição.");
		}
		genero.setDataInclusao(new Date());
		return this.repository.save(genero);
	}
	
	@Override
	public Genero update(Genero genero) {
		if (this.repository.existsByIdNotAndGeneroIgnoreCase(genero.getId(), genero.getGenero())) {
			throw new ObjectAlreadyExistsException("Já existe outro tipo com esta descrição.");
		}
		genero.setDataAlteracao(new Date());
		return this.repository.save(genero);
	}

}


