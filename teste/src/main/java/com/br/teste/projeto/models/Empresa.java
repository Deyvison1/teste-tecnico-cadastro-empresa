package com.br.teste.projeto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name =  "empresas")
public class Empresa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long codId;
	
	@NotNull
	@Column(length = 50, nullable = false)
	private String txNome;
	
}
