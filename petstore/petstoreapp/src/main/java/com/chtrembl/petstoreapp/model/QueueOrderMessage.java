package com.chtrembl.petstoreapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueOrderMessage {
    private Order order;
    private String containerName;
    private String orderId;
}
