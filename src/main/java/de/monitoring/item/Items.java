package de.monitoring.item;

import org.springframework.stereotype.Component;

@Component
public interface Items {
    Item createItem(Item item);
}
