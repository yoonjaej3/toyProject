package com.jyj.toyProject.modules.store.repository.interfaces;

import com.jyj.toyProject.modules.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository  extends JpaRepository<Store,Long> {
}
