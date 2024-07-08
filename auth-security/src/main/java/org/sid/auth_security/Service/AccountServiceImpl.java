package org.sid.auth_security.Service;

import jakarta.transaction.Transactional;
import org.sid.auth_security.Entity.AppRole;
import org.sid.auth_security.Entity.AppUser;
import org.sid.auth_security.Repository.AppRoleRepo;
import org.sid.auth_security.Repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepo appUserRepo;

    private AppRoleRepo appRoleRepo;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepo.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepo.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser=appUserRepo.findByUsername(username);
        AppRole appRole=appRoleRepo.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepo.findAll();
    }
}
