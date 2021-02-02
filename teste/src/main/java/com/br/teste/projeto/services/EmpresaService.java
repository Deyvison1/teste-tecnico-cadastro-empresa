package com.br.teste.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.teste.projeto.models.Empresa;
import com.br.teste.projeto.repository.IEmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private IEmpresaRepository empresaRepository;
	
	/**
	 * Persiste o dados de uma empresa no banco.<br>
	 * Atributos de preenchimento <b>txNome</b>.
	 * @param Empresa Objeto
	 * @return Empresa preenchido com a empresa persistida
	 */
	public Empresa save(Empresa pEmpresa) {
		return empresaRepository.save(pEmpresa);
	}
	
	
	
	/**
	 * Recupera as empresas cadastradas no banco.<br>
	 * Atributos de preenchimento <b>Nenhum</b>.
	 * @param Empresa Objeto
	 * @return lista Empresa que estao cadastradas no banco sem filtro
	 */
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}
	
	/**
	 * Exclui uma empresa do banco.<br>
	 * Atributos de preenchimento <b>Empresa empresa</b>.
	 * @param Empresa Objeto
	 * @return a mensagem de sucesso ou n sucesso
	 */
	public boolean delete(@PathVariable Long codId) {
		Empresa empresa = empresaRepository.findById(codId).get();
		
		if(empresa == null) {
			 return false;
		}
		empresaRepository.delete(empresa);
		return true;
	}
	
}
