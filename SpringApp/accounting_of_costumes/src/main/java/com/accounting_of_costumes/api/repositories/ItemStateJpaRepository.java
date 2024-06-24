package com.accounting_of_costumes.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.entities.ItemState;

public interface ItemStateJpaRepository extends JpaRepository<ItemState, String>{
    Optional<ItemState> findByName(String name);
}
