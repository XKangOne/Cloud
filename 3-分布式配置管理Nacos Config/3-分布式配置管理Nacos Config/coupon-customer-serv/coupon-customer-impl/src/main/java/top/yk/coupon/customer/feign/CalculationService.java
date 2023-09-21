package top.yk.coupon.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.yk.coupon.calculation.api.beans.ShoppingCart;
import top.yk.coupon.calculation.api.beans.SimulationOrder;
import top.yk.coupon.calculation.api.beans.SimulationResponse;

@FeignClient(value = "coupon-calculation-serv" ,path = "/calculator")
public interface CalculationService {
    @PostMapping("/checkout")
    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    @PostMapping("/simulate")
    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
