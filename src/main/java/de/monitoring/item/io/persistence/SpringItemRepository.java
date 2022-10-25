package de.monitoring.item.io.persistence;

import de.monitoring.item.Item;
import org.springframework.data.repository.Repository;

public interface SpringItemRepository extends Repository<Item, Long> {

    Item save(Item item);

}
