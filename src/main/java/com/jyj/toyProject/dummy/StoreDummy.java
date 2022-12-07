package com.jyj.toyProject.dummy;


import com.jyj.toyProject.api.festival.entity.Festival;
import com.jyj.toyProject.api.store.entity.Store;
import com.jyj.toyProject.api.store.repository.interfaces.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class StoreDummy {

    private final StoreRepository storeRepository;

    public Store createStore(Festival festival,int index){
        Store store=Store.builder()
                .festival(festival)
                .name("가게"+index)
                .phone("0101111222"+index)
                .build();

        Store savedStore=storeRepository.save(store);

        return savedStore;
    }
}
