package top.yk.coupon.calculation.service;

import org.springframework.web.bind.annotation.RequestBody;
import top.yk.coupon.calculation.api.beans.ShoppingCart;
import top.yk.coupon.calculation.api.beans.SimulationOrder;
import top.yk.coupon.calculation.api.beans.SimulationResponse;

public interface CouponCalculationService {
    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);

}
