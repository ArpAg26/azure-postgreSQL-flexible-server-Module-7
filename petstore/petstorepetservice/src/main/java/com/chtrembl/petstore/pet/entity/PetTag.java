package com.chtrembl.petstore.pet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet_tag", schema = "public")
public class PetTag {
    @EmbeddedId
    private PetTagId id;
    @ManyToOne
    @MapsId("petId")
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;
}