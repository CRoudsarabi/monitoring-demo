package de.monitoring.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemAppService {

    @Autowired
    private Items items;


    public Item createItem(AddItemCommand command) {
        var article = new Item(command.name(), command.description());
        return items.createItem(article);
    }
}
