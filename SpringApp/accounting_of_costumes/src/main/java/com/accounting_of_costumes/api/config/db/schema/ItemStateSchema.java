package com.accounting_of_costumes.api.config.db.schema;

import java.util.Set;

import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="item_state")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "items")
public class ItemStateSchema {

    @Id
    @Column(name="state_name",nullable=false)
    private String name;

    @OneToMany(mappedBy = "state")
    private Set<ItemSchema> items;

    public ItemState toItemState(){
        return new ItemState(this.name);
    }
}
