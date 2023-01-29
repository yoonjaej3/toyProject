package com.jyj.toyProject.api.item.repository.interfaces;

import com.jyj.toyProject.api.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item,Long> {

    Item findSeqById(String id);

}
