package com.cjw.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SysConfig {
//注入工厂
    @Autowired
    CachingConnectionFactory connectionFactory;

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate (){
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue queueOne(){
        return new Queue("one");
    }

    @Bean
    public Queue queueTwo(){
        return new Queue("two");
    }

    @Bean
    public Queue queueThree(){
        return new Queue("three");
    }

    @Bean
    public Queue queueFour(){
        return new Queue("four");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding oneToDirectExchange(Queue queueOne, DirectExchange directExchange){
        return BindingBuilder.bind(queueOne).to(directExchange).with("j178.one");
    }

    @Bean
    public Binding twoToTopicExchange(Queue queueTwo, TopicExchange topicExchange){
        return BindingBuilder.bind(queueTwo).to(topicExchange).with("topic.#");
    }

    @Bean
    public Binding threeToFanoutExchange(Queue queueThree, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueThree).to(fanoutExchange);
    }

    @Bean
    public Binding fourTotoFanoutExchange(Queue queueFour, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueFour).to(fanoutExchange);
    }
}
