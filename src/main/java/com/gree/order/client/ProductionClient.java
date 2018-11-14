package com.gree.order.client;

import com.gree.order.entity.dto.CartDto;
import com.gree.order.entity.dto.ProductionDtos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/11/12 15:37.
 */
@FeignClient(name = "production")
public interface ProductionClient {
    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/listForOrder")
    List<ProductionDtos> listForOrder(List<String> productIdList);

    @PostMapping("decrementStock")
    void decrementStock(List<CartDto> cartDtoList);
}
