package com.accounting_of_costumes.entities.OperationType.gateway;

import com.accounting_of_costumes.api.config.db.schema.OperationTypeSchema;

import java.util.List;
import java.util.Optional;

public interface OperationTypeGateway {
    OperationTypeSchema create(OperationTypeSchema type);
    OperationTypeSchema update(OperationTypeSchema type);
    void delete(OperationTypeSchema type);

    Optional<OperationTypeSchema> findByName(String name);

    List<OperationTypeSchema> findAll();
}
