package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;

public interface PaymentService {
    void confirmPayment(OrderDTO orderDTO);
}
