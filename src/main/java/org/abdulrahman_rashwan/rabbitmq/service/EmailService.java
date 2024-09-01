package org.abdulrahman_rashwan.rabbitmq.service;

import org.abdulrahman_rashwan.rabbitmq.dto.OrderDTO;

public interface EmailService {
    void sendOrderConfirmation(OrderDTO orderDTO);
}
