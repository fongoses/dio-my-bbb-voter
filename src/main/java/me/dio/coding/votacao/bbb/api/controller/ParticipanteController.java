package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipanteRepository;

@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor
public class ParticipanteController {

	private final ParticipanteRepository repository;
	
	@PostMapping("/salvar")
	public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
		ParticipanteModel entidade = repository.save(participante);
		return ResponseEntity.ok(entidade);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<ParticipanteModel> consultar(@RequestParam String id) {
		Optional<ParticipanteModel> opt = repository.findById(id);
		
		if(opt.isEmpty()) {
			return ResponseEntity.notFound().build(); // Retorna HTTP Status 404
		}
		
		return ResponseEntity.ok(opt.get());
	}
}
