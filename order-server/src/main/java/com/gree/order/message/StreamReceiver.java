package com.gree.order.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by 260152(AWU) on 2018/11/17 14:25.
 */
@Component
@EnableBinding(Processor.class)
public class StreamReceiver {

    @StreamListener(Processor.INPUT)
    public void process(Object message) {
        System.out.println(message);
    }
}
