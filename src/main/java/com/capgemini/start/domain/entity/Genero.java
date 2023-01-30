package com.capgemini.start.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_genero")
public class Genero {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_GENERO", nullable = false)
	private Integer id;
	
	@Column(name="DS_GENERO", nullable = false, length = 100)
	private String descricao;
	
	@Column(name="DT_INCLUSAO", nullable = false)
	private Date dataInclusao;
	
	@Column(name="DT_ALTERACAO")
	private Date dataAlteracao;
	
	

}
