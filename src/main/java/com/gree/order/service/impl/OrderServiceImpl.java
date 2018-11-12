package com.gree.order.service.impl;

import com.gree.order.entity.dto.OrderDto;
import com.gree.order.service.OrderService;
import com.gree.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by 260152(AWU) on 2018/10/30 8:24.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDto create(OrderDto orderDto) {
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(orderDto, dto);
        dto.setOrderId(KeyUtils.getKey());
        System.out.println("orderDto被保存调用了");
        return dto;
    }
}
