package com.chtrembl.petstore.pet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PetTagId implements Serializable {
    @Column(name = "pet_id")
    private Long petId;
    @Column(name = "tag_id")
    private Long tagId;
}
