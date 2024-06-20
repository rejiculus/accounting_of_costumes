package com.accounting_of_costumes.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="first_name",nullable=false, length=20)
    private String first_name;

    @Column(name="last_name",nullable=false, length=20)
    private String last_name;

    @Column(name="job_title",nullable=true, length=100)
    private String job_title = "Неизвестно";

    @Column(name="user_comment", nullable = true)
    private String user_comment;

    @OneToMany(mappedBy = "person")
    private Set<Operation> operations;
}
