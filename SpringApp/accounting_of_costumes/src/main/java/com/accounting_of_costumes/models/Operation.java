package com.accounting_of_costumes.models;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="operation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString()
public class Operation {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="operation_date",columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime operationDate;
    
    @ManyToOne
    @JoinColumn(name="person_fk",nullable=false)
    private Person person;

    @ManyToOne
    @JoinColumn(name="operation_type_fk", nullable=false)
    private OperationType type;
    
    @ManyToMany(managedBy="operations")
    private Set<Item> items;
}
