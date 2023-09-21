package org.example.coupon.calculation.template;


import org.example.coupon.template.api.beans.ShoppingCart;

/**
 * RuleTemplate---模板规则接口
 */
public interface RuleTemplate {
    /**
     * 计算优惠券
     */
    ShoppingCart calculate(ShoppingCart settlement);
}
