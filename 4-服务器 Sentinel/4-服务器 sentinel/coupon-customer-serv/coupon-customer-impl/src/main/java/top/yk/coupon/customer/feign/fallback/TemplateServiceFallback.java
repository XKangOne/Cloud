package top.yk.coupon.customer.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.yk.coupon.customer.feign.TemplateService;
import top.yk.coupon.template.api.beans.CouponTemplateInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Component
public class TemplateServiceFallback implements TemplateService {
    @Override
    public CouponTemplateInfo getTemplate(Long id) {
        log.info("根据id获取模板优惠卷降级逻辑");
        return CouponTemplateInfo.builder().id(123L).name("降价优惠卷").desc("一张降级优惠卷").type("折扣").shopId(123L).rule(null).available(true).build();
    }

    @Override
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
        log.info("批量获取模板优惠卷降级逻辑");
        Map<Long,CouponTemplateInfo> map = new HashMap<>();
        map.put(1L,CouponTemplateInfo.builder().id(123L).name("降价优惠卷").desc("一张降级优惠卷").type("折扣").shopId(123L).rule(null).available(true).build());
        return map;
    }
}
