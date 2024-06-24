package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.OperationType;
import com.accounting_of_costumes.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface OperationTypeRepository {
    //U update
    //C create
    OperationType save(OperationType type);

    //R read
    List<OperationType> findAll();
    Optional<OperationType> findByName(String name);

    //D delete
    void delete(OperationType type);
}
