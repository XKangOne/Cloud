package org.example.coupon.customer.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.example.coupon.customer.feign.TemplateService;
import org.example.coupon.template.beans.CouponTemplateInfo;
import org.springframework.stereotype.Component;

import javax.xml.transform.Templates;
import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
public class TemplateServiceFallback implements TemplateService {


    @Override
    public CouponTemplateInfo getTemplate(Long id) {
        log.info("根据id获取优惠券模板降级逻辑");
        return null;
    }

    @Override
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
        log.info("批量获取优惠券模板降级逻辑");
        return null;


    }
}
