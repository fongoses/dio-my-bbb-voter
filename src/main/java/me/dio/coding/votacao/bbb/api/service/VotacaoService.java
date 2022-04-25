package me.dio.coding.votacao.bbb.api.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;

@Service
@AllArgsConstructor
public class VotacaoService {
	
	private static final String TOPICO_VOTACAO = "votacao";
	
	private final KafkaTemplate<Object, Object> template;
	
	public void adicionarEvento(ParticipanteModel participante) {
		template.send(TOPICO_VOTACAO, participante);
	}

}
