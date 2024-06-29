package com.accounting_of_costumes.entities.Operation.gateway;

import com.accounting_of_costumes.api.config.db.schema.OperationSchema;

import java.util.List;
import java.util.Optional;

public interface OperationGateway {
    OperationSchema create(OperationSchema operation);
    OperationSchema update(OperationSchema operationSchema);
    void delete(OperationSchema operationSchema);

    Optional<OperationSchema> findById(Long id);

    List<OperationSchema> findAll();
}
