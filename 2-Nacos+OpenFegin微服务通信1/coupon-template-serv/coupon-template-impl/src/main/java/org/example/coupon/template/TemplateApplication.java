package org.example.coupon.template;


import org.hibernate.sql.Template;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"org.example"})
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}