package de.monitoring.orders.io.persistence;

import de.monitoring.orders.Order;
import org.springframework.data.repository.Repository;

public interface SpringOrderRepository extends Repository<Order, Long> {

    Order save(Order order);
}
