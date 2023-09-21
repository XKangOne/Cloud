package top.yk.coupon.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.yk.coupon.customer.feign.fallback.TemplateServiceFallbackFactory;
import top.yk.coupon.template.api.beans.CouponTemplateInfo;

import java.util.Collection;
import java.util.Map;

@FeignClient(value = "coupon-template-serv",path = "/template",fallbackFactory = TemplateServiceFallbackFactory.class)
public interface TemplateService {
    @GetMapping("/getTemplate")
    CouponTemplateInfo getTemplate(@RequestParam("id") Long id);

    @GetMapping("/getBatch")
    Map<Long,CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids")Collection<Long> ids);
}
