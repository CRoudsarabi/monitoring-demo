package de.monitoring.orders;

import org.springframework.stereotype.Component;

@Component
public interface Orders {

    Order createOrder(Order order);
}
