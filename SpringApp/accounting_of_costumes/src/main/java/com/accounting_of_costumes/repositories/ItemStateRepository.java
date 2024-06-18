package com.accounting_of_costumes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.models.ItemState;

public interface ItemStateRepository extends JpaRepository<ItemState, String>{
    Optional<ItemState> findByName(String name);
}
