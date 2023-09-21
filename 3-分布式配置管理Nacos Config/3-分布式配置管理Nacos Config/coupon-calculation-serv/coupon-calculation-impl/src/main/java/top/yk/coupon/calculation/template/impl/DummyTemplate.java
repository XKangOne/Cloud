package top.yk.coupon.calculation.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.yk.coupon.calculation.api.beans.ShoppingCart;
import top.yk.coupon.calculation.template.AbstractRuleTemplate;
import top.yk.coupon.calculation.template.RuleTemplate;

@Component
@Slf4j
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        long orderTotalAmount = getTotalPrice(order.getProducts());
        order.setCost(orderTotalAmount);
        return order;
    }

    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }
}
