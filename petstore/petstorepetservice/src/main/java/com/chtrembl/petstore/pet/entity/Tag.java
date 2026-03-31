package com.chtrembl.petstore.pet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag", schema = "public")
public class Tag {
    @Id
    private Long id;
    @Column(nullable = false, unique = true, length = 64)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Pet> pets;
}