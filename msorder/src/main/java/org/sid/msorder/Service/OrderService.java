package org.sid.msorder.Service;
import lombok.NonNull;
import org.sid.msorder.Entity.Client;
import org.sid.msorder.Entity.Order;
import org.sid.msorder.Entity.OrderStatus;
import org.sid.msorder.Repository.ClientRepo;
import org.sid.msorder.Repository.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);



    public Page<Order> searchAllOrders(Pageable pageable) {
        Page<Order> orders = orderRepo.findAll(pageable);
        logger.info("Found orders: " + orders);
        return orders;
    }
    public Order findById(Long id) {

        return orderRepo.findById(id).orElse(null);
    }


    public Order createOrder(Order newOrder) {
        Client client = clientRepo.findById(newOrder.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        newOrder.setClient(client);
        return orderRepo.save(newOrder);
    }


    public Order getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepo.findById(orderId);
        return orderOptional.orElse(null);
    }

    public Page<Order> searchByClient(String name,Pageable pageable) {
        Page<Order> orders = orderRepo.findByClientFirstNameOrClientLastName(name,name,pageable);
        logger.info("Found orders: " + orders);
        return orders;
    }

    public Map<OrderStatus, List<Order>> searchByStatus() {
        Map<OrderStatus, List<Order>> ordersByStatus = new EnumMap<>(OrderStatus.class);
        for (OrderStatus status : OrderStatus.values()) {
            List<Order> orders = orderRepo.findByStatus(status);
            ordersByStatus.put(status, orders);
            logger.info("Found orders with status " + status + ": " + orders);
        }
        return ordersByStatus;
    }



}





