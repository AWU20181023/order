package com.gree.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.dc.pr.PRError;

/**
 * Created by 260152(AWU) on 2018/10/31 8:00.
 */
@RestController
public class ClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getProductionMsg")
    public String getProductionMsg() {
//        RestTemplate template = new RestTemplate();
//        String forObject = template.getForObject("http://172.16.227.132:8080/msg", String.class);

//        ServiceInstance production = loadBalancerClient.choose("PRODUCTION");
//        String url = String.format("http://%s:%s/msg", production.getHost(), production.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject(url, String.class);

        String forObject = restTemplate.getForObject("http://PRODUCTION/msg", String.class);
        System.out.println(forObject);
        return forObject;
    }
}
