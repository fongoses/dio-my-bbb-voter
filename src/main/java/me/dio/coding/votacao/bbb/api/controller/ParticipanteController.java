package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.coding.votacao.bbb.api.model.ParametroModel;
import me.dio.coding.votacao.bbb.api.repository.ParametroRepository;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

	private final ParametroRepository repository;
	
	public ParametroController(ParametroRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametro) {
		ParametroModel entidade = repository.save(parametro);
		return ResponseEntity.ok(entidade);
	}
	
	@GetMapping("/consulta")
	public ResponseEntity<ParametroModel> consulta(@RequestParam String chave) {
		Optional<ParametroModel> optParametro = repository.findById(chave);
		
		if(optParametro.isEmpty()) {
			return ResponseEntity.notFound().build(); // Retorna HTTP Status 404
		}
		
		return ResponseEntity.ok(optParametro.get());
	}
}
