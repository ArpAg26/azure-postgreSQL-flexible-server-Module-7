package com.chtrembl.petstore.pet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pet", schema = "public")
public class Pet {
    @Id
    private Long id;
    @Column(nullable = false, unique = true, length = 64)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Column(name = "photourl", nullable = false, length = 255)
    private String photoURL;
    @Column(nullable = false, length = 64)
    private String status;
    @ManyToMany
    @JoinTable(name = "pet_tag",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
}
