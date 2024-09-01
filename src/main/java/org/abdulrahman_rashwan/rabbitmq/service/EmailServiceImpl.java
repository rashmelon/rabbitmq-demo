package org.abdulrahman_rashwan.rabbitmq.service;

import org.abdulrahman_rashwan.rabbitmq.dto.OrderDTO;
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
