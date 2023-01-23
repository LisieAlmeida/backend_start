package com.capgemini.start.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.start.domain.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	
	
	boolean existsByGeneroIgnoreCase(String genero);
	
	boolean existsByIdNotAndGeneroIgnoreCase(Integer id, String genero);

}
