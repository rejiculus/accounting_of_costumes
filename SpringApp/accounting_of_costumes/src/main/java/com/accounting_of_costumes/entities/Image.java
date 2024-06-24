package com.accounting_of_costumes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "item")
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="image_source", nullable = false,length = 200)
    private String source;

    @ManyToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item;

}
