package com.chtrembl.petstore.order.mapper;

import com.chtrembl.petstore.order.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrderModel(com.chtrembl.petstore.order.entity.Order orderEntity) {
        if (orderEntity == null) {
            return null;
        }

        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setProducts(orderEntity.getProducts());
        order.setStatus(Order.Status.fromValue(orderEntity.getStatus()));
        order.setComplete(orderEntity.getComplete());
        order.setEmail(orderEntity.getEmail());

        return order;
    }

    public com.chtrembl.petstore.order.entity.Order toOrderEntity(Order orderModel) {
        if (orderModel == null) {
            return null;
        }

        com.chtrembl.petstore.order.entity.Order orderEntity = new com.chtrembl.petstore.order.entity.Order();
        orderEntity.setId(orderModel.getId());
        orderEntity.setProducts(orderModel.getProducts());
        orderEntity.setStatus(orderModel.getStatus().toString());
        orderEntity.setComplete(orderModel.getComplete());
        orderEntity.setEmail(orderModel.getEmail());

        return orderEntity;
    }
}
