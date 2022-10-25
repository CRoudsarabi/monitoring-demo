package de.monitoring.item.io.http;

import de.monitoring.item.ItemAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/customer")
public class ItemController {

    @Autowired
    private ItemAppService itemAppService;

    @Autowired
    private ItemTOMapper itemTOMapper;

    @PostMapping
    public ItemTO createArticle(@RequestBody AddItemCommandTO addItemCommandTO) {
        return itemTOMapper.mapToTO(itemAppService.createItem(itemTOMapper.mapToEntity(addItemCommandTO)));
    }
}
