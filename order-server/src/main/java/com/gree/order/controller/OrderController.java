package com.gree.order.controller;

import com.gree.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 260152(AWU) on 2018/10/30 16:11.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${dev}")
    private String dev;

    @GetMapping("print")
    public String printEnv() {
        return dev;
    }
}
