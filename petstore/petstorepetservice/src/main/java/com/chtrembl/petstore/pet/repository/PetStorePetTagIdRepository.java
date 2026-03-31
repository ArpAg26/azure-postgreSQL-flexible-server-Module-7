package com.chtrembl.petstore.pet.repository;

import com.chtrembl.petstore.pet.entity.PetTag;
import com.chtrembl.petstore.pet.entity.PetTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetStorePetTagIdRepository extends JpaRepository<PetTag, PetTagId> {
}
