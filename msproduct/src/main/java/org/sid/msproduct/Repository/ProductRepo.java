package org.sid.msproduct.Repository;

import org.sid.msproduct.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product,Long> {

}
