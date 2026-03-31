package com.chtrembl.petstore.product.repository;

import com.chtrembl.petstore.product.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetStoreProductTagRepository extends JpaRepository<Tag, Long> {
}
