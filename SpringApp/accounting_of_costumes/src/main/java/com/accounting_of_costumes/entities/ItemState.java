package com.accounting_of_costumes.entities;

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
@Table(name="item_state")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ItemState {

    @Id
    @Column(name="state_name",nullable=false)
    private String name;

    @OneToMany(mappedBy = "state")
    private Set<Item> items;
}
