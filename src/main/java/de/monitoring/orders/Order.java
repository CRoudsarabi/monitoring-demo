package de.monitoring.orders;


import de.monitoring.customer.Customer;
import de.monitoring.item.Item;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Item item;
    private Instant orderDate;
    private Integer amount;

    public Order(Customer customer, Item item, Instant orderDate, Integer amount) {
        this.customer = customer;
        this.item = item;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
    }

    public Instant getOrderDate() {
        return orderDate;
    }
}
