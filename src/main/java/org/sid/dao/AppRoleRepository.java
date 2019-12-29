package org.sid.dao;

import org.sid.entities.AppRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppRoleRepository extends MongoRepository<AppRole, String> {
    public AppRole findByRoleName(String roleName);
}
