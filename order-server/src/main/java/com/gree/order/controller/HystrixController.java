package com.gree.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by 260152(AWU) on 2018/11/19 20:21.
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @HystrixCommand(
            //  超时设置，默认1000ms
//            commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            commandProperties = {
                    // 断路器设置，是否启动断路器
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    // 请求阈值
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    // 请求时间范围内
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    //错误率
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            }
    )
    @GetMapping("getList")
    public String getList(int num) {
        if (num % 2 == 0) {
            return "success";
        }
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = template.postForEntity("http://localhost:8888/listForOrder", Collections.singletonList("2"), String.class);
        return stringResponseEntity.getBody();
    }

    private String fallback() {
        return "服务降级";
    }

    private String defaultFallback() {
        return "默认服务降级";
    }
}
