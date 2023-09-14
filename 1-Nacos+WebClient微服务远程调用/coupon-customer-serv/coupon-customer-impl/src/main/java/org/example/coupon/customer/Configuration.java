package org.example.coupon.customer;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@org.springframework.context.annotation.Configuration
public class Configuration {
    /*
       注册一个WebClient 的实例用来远程调用
    * */
    @Bean
    @LoadBalanced
    public WebClient.Builder register(){
        return WebClient.builder();
    }
}
