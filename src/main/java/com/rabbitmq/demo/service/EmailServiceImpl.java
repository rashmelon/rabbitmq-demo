package com.rabbitmq.demo.service;

import com.rabbitmq.demo.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendOrderConfirmation(OrderDTO orderDTO) {
        // simulate sending the email
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
