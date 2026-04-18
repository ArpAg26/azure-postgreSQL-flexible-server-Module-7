package com.chtrembl.petstoreapp.service;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.chtrembl.petstoreapp.model.QueueOrderMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderMessageQueueService {

    @Value("${spring.cloud.azure.servicebus.queue-name}")
    String queueName;
    @Value("${spring.cloud.azure.servicebus.namespace}")
    String serviceBusNamespace;

    public void sendMessage(QueueOrderMessage orderMessage) {
        String message = null;
        // create a token using the default Azure credential
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder()
                .build();

        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .fullyQualifiedNamespace(serviceBusNamespace)
                .credential(credential)
                .sender()
                .queueName(queueName)
                .buildClient();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            message = objectMapper.writeValueAsString(orderMessage);
        } catch (JsonProcessingException ex) {
            log.error("Some error happened while serializing the order message: {}", ex.getMessage(), ex);
        }
        // send one message to the queue
        senderClient.sendMessage(new ServiceBusMessage(message));
        System.out.println("Sent a single message : " + message + " to the queue: " + queueName);
    }
}
