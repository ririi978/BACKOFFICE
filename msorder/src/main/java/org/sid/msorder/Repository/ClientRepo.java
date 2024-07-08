package org.sid.msorder.Repository;

import org.sid.msorder.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
