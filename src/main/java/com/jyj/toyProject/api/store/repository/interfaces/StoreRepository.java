package com.jyj.toyProject.api.store.repository.interfaces;

import com.jyj.toyProject.api.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository  extends JpaRepository<Store,Long> {
}
