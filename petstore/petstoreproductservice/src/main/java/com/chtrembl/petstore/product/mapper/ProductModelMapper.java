package com.chtrembl.petstore.product.mapper;

import com.chtrembl.petstore.product.model.Category;
import com.chtrembl.petstore.product.model.Product;
import com.chtrembl.petstore.product.model.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ProductModelMapper {

    public List<Product> toProductModelList(List<com.chtrembl.petstore.product.entity.Product> productEntities) {
        List<Product> products = new ArrayList<>();
        productEntities.forEach(productEntity -> {
            Product product = new Product();
            product.setId(productEntity.getId());
            product.setName(productEntity.getName());
            product.setStatus(Product.Status.fromValue(productEntity.getStatus()));
            product.setPhotoURL(productEntity.getPhotoURL());
            product.setCategory(toCategoryModel(productEntity.getCategory()));
            product.setTags(toTagModelList(productEntity.getTags()));
            products.add(product);
        });
        return products;
    }

    public Product toProductModel(com.chtrembl.petstore.product.entity.Product productEntity) {
        if(productEntity == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setStatus(Product.Status.fromValue(productEntity.getStatus()));
        product.setPhotoURL(productEntity.getPhotoURL());
        product.setCategory(toCategoryModel(productEntity.getCategory()));
        product.setTags(toTagModelList(productEntity.getTags()));
        return product;
    }

    public Category toCategoryModel(com.chtrembl.petstore.product.entity.Category categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }

    public List<Tag> toTagModelList(Set<com.chtrembl.petstore.product.entity.Tag> tagEntities) {
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
