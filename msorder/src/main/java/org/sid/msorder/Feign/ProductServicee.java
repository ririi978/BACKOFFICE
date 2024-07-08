package org.sid.msorder.Feign;

import org.sid.msorder.Entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name = "msproduct", url = "http://localhost:8081/products")
public interface ProductServicee {

    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);
}



