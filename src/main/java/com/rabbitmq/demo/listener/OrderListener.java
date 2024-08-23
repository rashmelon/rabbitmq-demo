package com.rabbitmq.demo.listener;

import com.rabbitmq.demo.dto.OrderDTO;
import com.rabbitmq.demo.service.EmailService;
import com.rabbitmq.demo.service.InventoryService;
import com.rabbitmq.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
@Slf4j
public class OrderListener implements MessageListener {
    private final EmailService emailService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public OrderListener(EmailService emailService, InventoryService inventoryService, PaymentService paymentService) {
        this.emailService = emailService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    @Override
    public void onMessage(Message message) {
        ByteArrayInputStream in = new ByteArrayInputStream(message.getBody());
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(in);
            OrderDTO orderDTO = (OrderDTO) is.readObject();
            log.info("Received message from RabbitMQ: {}", orderDTO);

            paymentService.confirmPayment(orderDTO);
            inventoryService.reduceItemsAmount(orderDTO);
            emailService.sendOrderConfirmation(orderDTO);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}