package org.sid.dao;

import org.sid.entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends MongoRepository<AppUser, String> {
    public AppUser findByUsername(String username);
}
