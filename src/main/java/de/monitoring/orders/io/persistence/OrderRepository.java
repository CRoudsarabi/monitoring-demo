package de.monitoring.orders.io.persistence;

import de.monitoring.orders.Order;
import de.monitoring.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository implements Orders {

    @Autowired
    private SpringOrderRepository springOrderRepository;

    @Override
    public Order createOrder(Order order) {
        return springOrderRepository.save(order);
    }
}
