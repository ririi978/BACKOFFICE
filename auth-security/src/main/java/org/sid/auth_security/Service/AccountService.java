package org.sid.auth_security.Service;

import org.sid.auth_security.Entity.AppRole;
import org.sid.auth_security.Entity.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface     AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole AppRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();

}
