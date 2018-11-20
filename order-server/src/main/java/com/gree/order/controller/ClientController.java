package com.gree.order.controller;

import com.gree.order.message.StreamClient;
import com.gree.product.client.ProductionClient;
import com.gree.product.dto.CartDto;
import com.gree.product.dto.ProductionOutput;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/31 8:00.
 */
@RestController
@RefreshScope
@EnableBinding(Processor.class)
public class ClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductionClient productionClient;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${dev}")
    private String dev;
    @Autowired
    private Processor processor;

    @GetMapping("print")
    public String printEnv() {
        processor.output().send(MessageBuilder.withPayload("wo shi:" + new Date()).build());
//        amqpTemplate.convertAndSend("myQueue", new Date());
        return dev;
    }

    @GetMapping("getProductionMsg")
    public String getProductionMsg() {
//        RestTemplate template = new RestTemplate();
//        String forObject = template.getForObject("http://172.16.227.132:8080/msg", String.class);

//        ServiceInstance production = loadBalancerClient.choose("PRODUCTION");
//        String url = String.format("http://%s:%s/msg", production.getHost(), production.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject(url, String.class);

//        String forObject = restTemplate.getForObject("http://PRODUCTION/msg", String.class);
//        System.out.println(forObject);
        String s = productionClient.productMsg();
        return s;
    }

    @GetMapping("getProducMsg")
    public String getProducMsg() {
        List<ProductionOutput> productionDtos = productionClient.listForOrder(Arrays.asList("1", "3"));
        return dev;
    }

    @GetMapping("decrementStock")
    public void decrementStock() {
        CartDto cartDto = new CartDto();
        cartDto.setId("1");
        cartDto.setNum(2);
        List<CartDto> cartDtos = new LinkedList<>();
        cartDtos.add(cartDto);
        productionClient.decrementStock(cartDtos);
    }
}
