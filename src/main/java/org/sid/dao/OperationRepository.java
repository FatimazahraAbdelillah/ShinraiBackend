package org.sid.dao;

import org.sid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface OperationRepository extends MongoRepository<Operation, String> {
    @Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
    public Collection<Operation> listOperation(@Param("x") String codeCompte);
}
