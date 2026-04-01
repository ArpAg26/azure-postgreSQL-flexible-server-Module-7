package com.chtrembl.petstore.order.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.chtrembl.petstore.order.model.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Container(containerName = "orders", partitionKeyPath = "/id")
public class Order {
    @Id
    @PartitionKey
    private String id;
    private String email;
    private List<Product> products;
    private String status;
    private Boolean complete;
}
