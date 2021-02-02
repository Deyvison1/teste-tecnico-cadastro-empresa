package com.br.teste.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.teste.projeto.models.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {
}
