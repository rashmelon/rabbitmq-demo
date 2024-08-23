package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;

public interface EmailService {
    void sendOrderConfirmation(OrderDTO orderDTO);
}
