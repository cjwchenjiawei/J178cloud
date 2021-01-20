package com.cjw.movieOrder.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Bean
    public Queue queueOrder(){
        return new Queue("order");
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
