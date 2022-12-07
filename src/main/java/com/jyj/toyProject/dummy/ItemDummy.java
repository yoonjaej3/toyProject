package com.jyj.toyProject.dummy;

import com.jyj.toyProject.api.item.entity.Item;
import com.jyj.toyProject.api.item.repository.interfaces.ItemRepository;
import com.jyj.toyProject.api.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class ItemDummy {

    private final ItemRepository itemRepository;

    public Item createItem(Store store,String name,Long price) {
        Item item=Item.builder()
                .store(store)
                .name(name)
                .price(price)
                .imageFileName("피자사진")
                .imageFileUrl("/path")
                .build();

        Item savedItem=itemRepository.save(item);

        return savedItem;
    }
}
