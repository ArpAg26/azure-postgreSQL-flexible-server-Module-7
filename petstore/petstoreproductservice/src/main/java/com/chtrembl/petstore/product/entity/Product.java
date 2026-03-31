package com.chtrembl.petstore.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    private Long id;
    @Column(nullable = false, unique = true, length = 64)
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_category"))
    private Category category;
    @Column(name = "photoURL", nullable = false, length = 255)
    private String photoURL;
    @Column(nullable = false, length = 64)
    private String status;
    @ManyToMany
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

}
