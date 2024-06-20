package com.accounting_of_costumes.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="operation_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "operations")
public class OperationType {

    @Id
    @Column(name="type_name",nullable = false,length=20)
    private String typeName;

    @OneToMany(mappedBy="type")
    private Set<Operation> operations;
}
