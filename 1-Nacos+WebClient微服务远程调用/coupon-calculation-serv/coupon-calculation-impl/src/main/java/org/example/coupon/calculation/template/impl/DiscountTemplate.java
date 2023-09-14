package org.example.coupon.calculation.template.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.coupon.calculation.template.AbstractRuleTemplate;
import org.example.coupon.calculation.template.RuleTemplate;
import org.springframework.stereotype.Component;

/**
 * DiscountTemplate ---打折优惠券
 */

@Slf4j
@Component
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
        //计算使用优惠券之后的价格
        Long newPrice = convertToDecimal(shopAmount * (quota.doubleValue() / 100));
        log.debug("original price={},new price={}",totalAmount);
        return newPrice;
    }
}
