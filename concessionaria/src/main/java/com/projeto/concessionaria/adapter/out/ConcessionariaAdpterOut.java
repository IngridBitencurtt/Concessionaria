package com.projeto.concessionaria.adapter.out;

import com.projeto.concessionaria.repository.ConcessionariaControl;
import com.projeto.concessionaria.repository.ConcessionariaRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Service
public class ConcessionariaAdpterOut implements ConcessionariaPortOut{
    private final MongoTemplate mongoTemplate;
    private final ConcessionariaRepository concessionariaRepository;

    public ConcessionariaAdpterOut(MongoTemplate mongoTemplate, ConcessionariaRepository concessionariaRepository) {
        this.mongoTemplate = mongoTemplate;
        this.concessionariaRepository = concessionariaRepository;
    }

    @Override
    public List<ConcessionariaControl> findAllVehicle(String marca, String modelo, String tipoVeiculo, String cor, int ano, Double preco) {

        Query query = this.buildQuery(marca,modelo,tipoVeiculo,cor,ano,preco);
        return mongoTemplate.find(query, ConcessionariaControl.class);
    }

    private Query buildQuery(String tag,
                              String model,
                              String vehicletype,
                              String color,
                              int ano,
                              double price) {
        Query query = new Query();


        if (!ObjectUtils.isEmpty(tag)) {
            query.addCriteria(Criteria.where("nome").regex(tag, "i"));

        }
        if (!ObjectUtils.isEmpty(model)) {
            query.addCriteria(Criteria.where("genero").regex(model, "i"));
        }
        if (!ObjectUtils.isEmpty(vehicletype)) {
            query.addCriteria(Criteria.where("posicao").regex(String.valueOf(vehicletype), "i"));
        }
        if (!ObjectUtils.isEmpty(color)) {
            query.addCriteria(Criteria.where("especie").regex(color, "i"));
        }
        if (!ObjectUtils.isEmpty(ano)) {
            query.addCriteria(Criteria.where("recurso").regex(String.valueOf(ano), "i"));
        }
        if (!ObjectUtils.isEmpty(price)) {
            query.addCriteria(Criteria.where("tipoDeAlcance").regex(String.valueOf(price), "i"));
        }

        return query;
    }


}
