package com.cjw.movieOrder.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SysConfig implements WebMvcConfigurer {
    /**
     *  注入工厂
     */
    @Autowired
    CachingConnectionFactory connectionFactory;

    //创建restTemplet交给spring 容器
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate (){
        return new RabbitTemplate(connectionFactory);
    }

    //死信队列
    @Bean
    public  Queue deadQueue(){
        return new Queue("deadQueue");
    }
    //死信交换机
    @Bean
    public DirectExchange deadExchange(){
        return  new DirectExchange("deadExchange");
    }

    //死信交换机队列绑定
    @Bean
    public Binding deadQueueToDeadExchange(Queue deadQueue,DirectExchange deadExchange){
        return  BindingBuilder.bind(deadQueue).to(deadExchange).with("dead_routing_key");
    }

    @Bean
    public Queue queueOrder(){
//关联死信交换机
        Map<String, Object> args = new HashMap<>(3);
        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", "deadExchange");
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key","dead_routing_key");
        // x-message-ttl  声明队列的TTL
        args.put("x-message-ttl",30000);
        return QueueBuilder.durable("order").withArguments(args).build();
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding oneToDirectExchange(Queue queueOrder, DirectExchange directExchange){
        return BindingBuilder.bind(queueOrder).to(directExchange).with("j178.order");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/page/**")
                .addResourceLocations("classpath:/page/");
    }

    //配置跨域

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

}
