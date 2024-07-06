package com.accounting_of_costumes.api.config.db.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;

public interface ItemRepository extends JpaRepository<ItemSchema, Long> {
}
