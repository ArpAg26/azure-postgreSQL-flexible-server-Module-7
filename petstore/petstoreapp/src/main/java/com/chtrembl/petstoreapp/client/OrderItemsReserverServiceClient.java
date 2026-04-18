package com.chtrembl.petstoreapp.client;

import com.chtrembl.petstoreapp.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "order-items-reserver-service-client",
        url = "${petstore.service.orders.items.reserver.url}"
)
public interface OrderItemsReserverServiceClient {
    @PostMapping("/api/orderitemreservefunction")
    void retrieveOrderItems(@RequestBody Order orders, @RequestParam String containerName,
                            @RequestParam String sessionId);
}
