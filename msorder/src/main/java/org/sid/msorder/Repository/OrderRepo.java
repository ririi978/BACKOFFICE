package org.sid.msorder.Repository;
import org.sid.msorder.Entity.Order;
import org.sid.msorder.Entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
  List<Order> findByStatus(OrderStatus status);
  Page<Order> findAll(Pageable pageable);
  Page<Order> findByClientFirstNameOrClientLastName(String firstname,String lastname, Pageable pageable);
}
