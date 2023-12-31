package org.example.coupon.customer.feign;

import org.example.coupon.template.api.beans.ShoppingCart;
import org.example.coupon.template.api.beans.SimulationOrder;
import org.example.coupon.template.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "coupon-calculation-serv", path = "/calculator")
public interface CalculationService {
    /**
     * 优惠券结算
     * @param settlement 优惠券结算请求对象
     * @return 优惠券结算响应对象
     */
    @PostMapping("/checkout")
    ShoppingCart checkout(ShoppingCart settlement);

    /**
     * 优惠券列表挨个试算，给客户提示每个可用券的优惠额度，帮助挑选
     * @param simulator
     * @return
     */
    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulator);
}
