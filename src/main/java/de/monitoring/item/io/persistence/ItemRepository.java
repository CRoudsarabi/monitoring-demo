package de.monitoring.item.io.persistence;

import de.monitoring.item.Item;
import de.monitoring.item.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemRepository implements Items {

    @Autowired
    private SpringItemRepository springItemRepository;


    @Override
    public Item createItem(Item item) {
        return springItemRepository.save(item);
    }
}
