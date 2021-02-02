package com.br.teste.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.teste.projeto.models.Empresa;
import com.br.teste.projeto.services.EmpresaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/empresa"})
public class EmpresaController {

	
	
	@Autowired
	private EmpresaService empresaService;
	

	/**
	 * Persiste o dados de uma empresa no banco.<br>
	 * Atributos de preenchimento <b>txNome</b>.
	 * @param Empresa Objeto
	 * @return Empresa preenchido com a empresa persistida
	 */
	@PostMapping
	public ResponseEntity<Empresa> save(@RequestBody Empresa pEmpresa) throws Exception {
		try {
			return ResponseEntity.ok(empresaService.save(pEmpresa));
			
		} catch (Exception e) {
			throw new Exception("==> "+e.getMessage());
		}
	}
	
	/**
	 * Exclui uma empresa do banco.<br>
	 * Atributos de preenchimento <b>Empresa empresa</b>.
	 * @param Empresa Objeto
	 * @return a mensagem de sucesso ou n sucesso
	 */
	@DeleteMapping("/{codId}")
	public ResponseEntity<Boolean> delete(@PathVariable Long codId) throws Exception {
		try {
			return ResponseEntity.ok(empresaService.delete(codId));
		} catch (Exception e) {
			throw new Exception("==> "+e.getMessage());
		}
	}
	
	/**
	 * Recupera as empresas cadastradas no banco.<br>
	 * Atributos de preenchimento <b>Nenhum</b>.
	 * @param Empresa Objeto
	 * @return lista Empresa que estao cadastradas no banco sem filtro
	 */
	@GetMapping
	public ResponseEntity<List<Empresa>> findAll() throws Exception {
		try {
			return ResponseEntity.ok(empresaService.findAll());
			
		} catch (Exception e) {
			throw new Exception("==> "+e.getMessage());
		}
	}
	
}
