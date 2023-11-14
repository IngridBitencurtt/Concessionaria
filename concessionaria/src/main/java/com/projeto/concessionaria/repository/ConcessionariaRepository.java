package com.projeto.concessionaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConcessionariaRepository extends MongoRepository<ConcessionariaControl, String> {
}
