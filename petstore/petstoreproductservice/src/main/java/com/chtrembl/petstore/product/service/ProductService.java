package com.chtrembl.petstore.product.service;

import com.chtrembl.petstore.product.mapper.ProductModelMapper;
import com.chtrembl.petstore.product.model.DataPreload;
import com.chtrembl.petstore.product.model.Product;
import com.chtrembl.petstore.product.repository.PetStoreProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final DataPreload dataPreload;
    private final PetStoreProductRepository petStoreProductRepository;
    private final ProductModelMapper productMapper;

    public List<Product> findProductsByStatus(List<String> status) {
        log.info("Finding products with status: {}", status);
        List<com.chtrembl.petstore.product.entity.Product> productsByStatus =
                petStoreProductRepository.findByStatusIn(status);
        return productMapper.toProductModelList(productsByStatus);

//        return dataPreload.getProducts().stream()
//                .filter(product -> status.contains(product.getStatus().getValue()))
//                .toList();
    }

    public Optional<Product> findProductById(Long productId) {
        log.info("Finding product with id: {}", productId);
        Optional<com.chtrembl.petstore.product.entity.Product> productById =
                petStoreProductRepository.findById(productId);
        return Optional.of(productMapper.toProductModel(petStoreProductRepository.findById(productId)
                .orElse(null)));

//        return dataPreload.getProducts().stream()
//                .filter(product -> product.getId().equals(productId))
//                .findFirst();
    }

    public List<Product> getAllProducts() {
        log.info("Getting all products");
        List<com.chtrembl.petstore.product.entity.Product> allProducts = petStoreProductRepository.findAll();
        return productMapper.toProductModelList(allProducts);
//        return dataPreload.getProducts();
    }

    public int getProductCount() {
        return petStoreProductRepository.findAll().size();
//        return dataPreload.getProducts().size();
    }
}