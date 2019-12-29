package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String username, String email, String password, String confirmedPassword);
    public AppUser loadUserByUsername(String username);
    public AppRole save(AppRole role);
    public void addRoleToUser(String username, String rolename);
}
