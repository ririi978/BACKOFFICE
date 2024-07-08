package org.sid.msproduct.Repository;

import org.sid.msproduct.Entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AttributeRepo extends JpaRepository<Attribute,Long> {


}
