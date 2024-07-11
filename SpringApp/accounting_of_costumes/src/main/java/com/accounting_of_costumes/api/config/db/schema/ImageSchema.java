package com.accounting_of_costumes.api.config.db.schema;

import com.accounting_of_costumes.entities.Image.model.Image;
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
public class ImageSchema {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="image_source", nullable = false,length = 200)
    private String source;

    @ManyToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private ItemSchema item;

    public ImageSchema(Image image){
        this.id = image.getId();
        this.source = image.getSource();
        this.item = new ItemSchema(image.getItem());
    }

    public Image toImage(){
        Image image = new Image(this.source);
        image.setId(this.id);
        return image;
    }
}
