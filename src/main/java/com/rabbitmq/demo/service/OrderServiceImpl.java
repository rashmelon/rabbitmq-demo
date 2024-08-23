package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.rabbitmq.demo.configuration.RabbitMQConfiguration.ORDER_EXCHANGE;
import static com.rabbitmq.demo.configuration.RabbitMQConfiguration.ORDER_ROUTING_KEY;

@Service
public class OrderServiceImpl implements OrderService {

    private final EmailService emailService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final RabbitTemplate rabbitTemplate;

    public OrderServiceImpl(EmailService emailService, InventoryService inventoryService, PaymentService paymentService, RabbitTemplate rabbitTemplate) {
        this.emailService = emailService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void create(OrderDTO orderDTO) {
        paymentService.confirmPayment(orderDTO);
        inventoryService.reduceItemsAmount(orderDTO);
        emailService.sendOrderConfirmation(orderDTO);
    }

    @Override
    public void createWithRabbitMQ(OrderDTO orderDTO) {
        rabbitTemplate.convertAndSend(ORDER_EXCHANGE, ORDER_ROUTING_KEY, orderDTO);
    }
}
