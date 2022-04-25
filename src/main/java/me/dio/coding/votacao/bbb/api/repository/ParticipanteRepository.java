package me.dio.coding.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String>{

}
