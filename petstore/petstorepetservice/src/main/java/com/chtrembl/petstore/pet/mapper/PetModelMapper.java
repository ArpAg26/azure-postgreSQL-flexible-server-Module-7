package com.chtrembl.petstore.pet.mapper;

import com.chtrembl.petstore.pet.model.Category;
import com.chtrembl.petstore.pet.model.Pet;
import com.chtrembl.petstore.pet.model.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PetModelMapper {

    public List<Pet> toPetModelList(List<com.chtrembl.petstore.pet.entity.Pet> petEntities) {
        List<Pet> petModels = new ArrayList<>();
        petEntities.forEach(petEntity -> {
            Pet petModel = new Pet();
            petModel.setId(petEntity.getId());
            petModel.setName(petEntity.getName());
            petModel.setCategory(toCategoryModel(petEntity.getCategory()));
            petModel.setStatus(Pet.Status.fromValue(petEntity.getStatus()));
            petModel.setPhotoURL(petEntity.getPhotoURL());
            petModel.setTags(toTagList(petEntity.getTags()));
            petModels.add(petModel);
        });
        return petModels;
    }

    public Pet toPetModel(com.chtrembl.petstore.pet.entity.Pet petEntity) {
        if(petEntity == null){
            return null;
        }
        Pet petModel = new Pet();
        petModel.setId(petEntity.getId());
        petModel.setName(petEntity.getName());
        petModel.setCategory(toCategoryModel(petEntity.getCategory()));
        petModel.setStatus(Pet.Status.fromValue(petEntity.getStatus()));
        petModel.setPhotoURL(petEntity.getPhotoURL());
        petModel.setTags(toTagList(petEntity.getTags()));
        return petModel;
    }

    public Category toCategoryModel(com.chtrembl.petstore.pet.entity.Category categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }

    public List<Tag> toTagList(java.util.Set<com.chtrembl.petstore.pet.entity.Tag> tagEntities) {
        if(tagEntities.isEmpty()){
            return Collections.emptyList();
        }
        List<Tag> tags = new ArrayList<>();
        tagEntities.forEach(tagEntity -> {
            Tag tag = new Tag();
            tag.setId(tagEntity.getId());
            tag.setName(tagEntity.getName());
            tags.add(tag);
        });
        return tags;
    }

}
