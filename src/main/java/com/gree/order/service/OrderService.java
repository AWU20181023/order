package com.gree.order.service;

import com.gree.order.entity.dto.OrderDto;

/**
 * Created by 260152(AWU) on 2018/10/30 8:23.
 */
public interface OrderService {
    OrderDto create(OrderDto orderDto);
}
