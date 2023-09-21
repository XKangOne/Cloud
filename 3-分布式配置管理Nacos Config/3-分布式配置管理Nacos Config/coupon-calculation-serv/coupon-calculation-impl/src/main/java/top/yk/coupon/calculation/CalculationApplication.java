package top.yk.coupon.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author moqi
 */
@SpringBootApplication
@ComponentScan(basePackages = {"top.yk"})
public class CalculationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class, args);
    }
}
