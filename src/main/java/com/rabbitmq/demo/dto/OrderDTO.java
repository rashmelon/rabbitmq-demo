package com.rabbitmq.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable {
    private List<String> items;
}
