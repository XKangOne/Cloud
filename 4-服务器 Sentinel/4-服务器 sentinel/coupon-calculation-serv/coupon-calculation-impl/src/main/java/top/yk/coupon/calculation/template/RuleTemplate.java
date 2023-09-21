package top.yk.coupon.calculation.template;

import top.yk.coupon.calculation.api.beans.ShoppingCart;

public interface RuleTemplate {

    ShoppingCart calculate(ShoppingCart settlement);
}
