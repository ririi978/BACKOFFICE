package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.Product;
import org.sid.msproduct.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public Product addProduct(Product product) {
        return productRepo.save(product);
    }


    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }


    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable);
    }


    public Optional<Product> findProductById(Long id) {
        return productRepo.findById(id);
    }


    public void deleteProductById(Long id) {

        productRepo.deleteById(id);
    }
}
