package com.jyj.toyProject.api.item.repository.interfaces;

import com.jyj.toyProject.api.item.dto.ItemResponseDto;
import com.jyj.toyProject.api.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepositoryCutsom {

    List<ItemResponseDto> findStore(String storeName);

    Item findItemByItdmId(String itemId);

}
