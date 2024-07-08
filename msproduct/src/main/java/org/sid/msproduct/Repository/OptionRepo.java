package org.sid.msproduct.Repository;

import org.sid.msproduct.Entity.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface OptionRepo extends JpaRepository<Option,Long> {
    Page<Option> findByTitleContainingIgnoreCase(String title, Pageable pageable);

}
