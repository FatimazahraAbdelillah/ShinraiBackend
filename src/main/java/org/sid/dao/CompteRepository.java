package org.sid.dao;

import org.sid.entities.Compte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface CompteRepository extends MongoRepository<Compte, String> {
    List<Compte> findCompteByCodeCompte(@Param("code") String codeCompte);
}
