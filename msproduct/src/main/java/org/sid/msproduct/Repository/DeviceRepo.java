package org.sid.msproduct.Repository;

import org.sid.msproduct.Entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface DeviceRepo extends JpaRepository<Device, Long> {
    Page<Device> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}

