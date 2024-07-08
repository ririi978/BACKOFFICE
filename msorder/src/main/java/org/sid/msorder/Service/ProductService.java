package org.sid.msorder.Service;

import jakarta.persistence.criteria.Order;
import org.sid.msorder.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private OrderRepo orderRepo;
    public Order getOrderById(Long id) {
        return (Order) orderRepo.findById(id).orElse(null);

    }
}
