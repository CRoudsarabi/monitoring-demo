package de.monitoring.item.io.http;

import de.monitoring.item.AddItemCommand;
import de.monitoring.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemTOMapper {

    public AddItemCommand mapToEntity(AddItemCommandTO addItemCommandTO) {
        return new AddItemCommand(addItemCommandTO.name(), addItemCommandTO.description());
    }

    public ItemTO mapToTO(Item item) {
        return new ItemTO(item.getId(), item.getName(), item.getDescription());
    }
}
