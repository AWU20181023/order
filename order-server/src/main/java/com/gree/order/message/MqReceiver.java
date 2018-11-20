package com.gree.order.message;

import org.springframework.stereotype.Component;

/**
 * Created by 260152(AWU) on 2018/11/17 11:34.
 */
@Component
public class MqReceiver {
    //    @RabbitListener(queues = "myQueue")
//    自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
//    自动创建exchange和queue绑定
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange")))
    public void process(String message) {
        System.out.println(message);
    }
}
