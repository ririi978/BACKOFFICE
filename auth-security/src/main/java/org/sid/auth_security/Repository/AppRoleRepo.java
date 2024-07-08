package org.sid.auth_security.Repository;

import org.sid.auth_security.Entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
