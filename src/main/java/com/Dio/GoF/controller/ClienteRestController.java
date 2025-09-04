package com.Dio.GoF.controller;

import com.Dio.GoF.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;
import com.Dio.GoF.service.ClienteService;


@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(clienteService.buscarPorId(id));
		} catch (RuntimeException e) {
			throw new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		try {
			clienteService.inserir(cliente);
			return ResponseEntity.ok(cliente);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, e.getMessage(), e);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		try {
			clienteService.atualizar(id, cliente);
			return ResponseEntity.ok(cliente);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
