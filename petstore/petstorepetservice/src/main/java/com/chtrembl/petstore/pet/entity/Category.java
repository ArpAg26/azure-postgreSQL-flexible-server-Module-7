package com.chtrembl.petstore.pet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category", schema = "public")
public class Category {
    @Id
    private Long id;
    @Column(nullable = false, unique = true, length = 64)
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Pet> pets;
}