package org.example.coupon.calculation.service;

import org.example.coupon.template.api.beans.ShoppingCart;
import org.example.coupon.template.api.beans.SimulationOrder;
import org.example.coupon.template.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
