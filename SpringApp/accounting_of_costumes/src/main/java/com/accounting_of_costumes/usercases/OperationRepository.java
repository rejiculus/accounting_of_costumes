package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.Operation;
import com.accounting_of_costumes.entities.OperationType;

import java.util.List;
import java.util.Optional;

public interface OperationRepository {
    //U update
    //C create
    Operation save(Operation operation);

    //R read
    List<Operation> findAll();
    Optional<Operation> findById(Long id);
    //find by person
    //find by item

    //D delete
    void delete(Operation operation);
}
