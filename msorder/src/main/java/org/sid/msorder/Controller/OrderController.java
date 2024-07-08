package org.sid.msorder.Controller;
import org.sid.msorder.Entity.Order;
import org.sid.msorder.Entity.OrderStatus;
import org.sid.msorder.Service.OrderService;
import org.sid.msorder.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder) {
        Order createdOrder = orderService.createOrder(newOrder);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping
    public ResponseEntity<Page<Order>> searchAllOrders(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orders = orderService.searchAllOrders(pageable);
        return ResponseEntity.ok(orders);
    }



    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {
        Order order = (Order) productService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @GetMapping("/byClient")
    public ResponseEntity<Page<Order>> searchByClient(@RequestParam(name = "name") String name,@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orders = orderService.searchByClient(name,pageable);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/byStatus")
    public ResponseEntity<Map<OrderStatus, List<Order>>> searchByStatus() {
        Map<OrderStatus, List<Order>> ordersByStatus = orderService.searchByStatus();
        return ResponseEntity.ok(ordersByStatus);
    }

}




