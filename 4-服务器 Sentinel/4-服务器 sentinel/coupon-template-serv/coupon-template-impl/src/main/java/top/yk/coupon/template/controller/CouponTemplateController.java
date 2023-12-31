package top.yk.coupon.template.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.yk.coupon.template.api.beans.CouponTemplateInfo;
import top.yk.coupon.template.api.beans.PagedCouponTemplateInfo;
import top.yk.coupon.template.api.beans.TemplateSearchParams;
import top.yk.coupon.template.service.CouponTemplateService;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mqxu
 * @date 2023/9/8
 * @description CouponTemplateController
 **/
@Slf4j
@RestController
@RequestMapping("/template")
public class CouponTemplateController {

    @Resource
    private CouponTemplateService couponTemplateService;

    /**
     * 创建优惠券
     *
     * @param request {@link CouponTemplateInfo}
     * @return {@link CouponTemplateInfo}
     */
    @PostMapping("/addTemplate")
    public CouponTemplateInfo addTemplate(@Valid @RequestBody CouponTemplateInfo request) {
        log.info("Create coupon template: data={}", request);
        return couponTemplateService.createTemplate(request);
    }

    /**
     * 克隆优惠券
     *
     * @param templateId 模板id
     * @return {@link CouponTemplateInfo}
     */
    @PostMapping("/cloneTemplate")
    public CouponTemplateInfo cloneTemplate(@RequestParam("id") Long templateId) {
        log.info("Clone coupon template: data={}", templateId);
        return couponTemplateService.cloneTemplate(templateId);
    }

    /**
     * 读取优惠券
     *
     * @param id 模板id
     * @return {@link CouponTemplateInfo}
     */
    @GetMapping("/getTemplate")
    public CouponTemplateInfo getTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id={}", id);
        return couponTemplateService.loadTemplateInfo(id);
    }

    /**
     * 批量获取
     *
     * @param ids 模板id
     * @return {@link Map<Long, CouponTemplateInfo>}
     */
    @GetMapping("/getBatch")
    @SentinelResource(value = "getTemplateInBatch", blockHandler = "getTemplateInBatchBlock",fallback = "getTemplateInBatchFallback")
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids) {
        //如果接口被熔断，观察以下日志是否被打印
        log.info("getTemplateInBatch: {}", JSON.toJSONString(ids));
        log.info("getTemplateInBatch 被调用！！！");
        //当 Template 批量查询服务的ID数量为3时抛出异常，验证熔断器的效果
        if (ids.size() == 3) {
            throw new RuntimeException();
        }

        return couponTemplateService.getTemplateInfoMap(ids);
    }

    /*
    * 批量查询优惠券模板接口被限流时的方法
    * */
    public Map<Long, CouponTemplateInfo> getTemplateInBatchBlock(Collection<Long> ids, BlockException exception) {
        log.info("批量查询优惠券模板接口被限流");
        CouponTemplateInfo couponTemplateInfo = CouponTemplateInfo.builder()
                .name("限流后返回的优惠券")
                .desc("限流后返回的优惠券")
                .type("1")
                .rule(null)
                .build();
        Map<Long, CouponTemplateInfo> map = new HashMap<>();
        map.put(1L,couponTemplateInfo);
        return map;

        //        log.info("接口被限流");
//        log.info(ids.toString());
//        log.info(exception.getMessage());
//        return Maps.newHashMap();
    }

    /*
    * 批量查询优惠券模板接口被降级时的方法
    * */
    public Map<Long, CouponTemplateInfo> getTemplateInBatchFallback(Collection<Long> ids) {
        log.info("批量查询优惠券模板接口被降级");
        CouponTemplateInfo couponTemplateInfo = CouponTemplateInfo.builder()
                .name("降级后返回的优惠券")
                .desc("降级后返回的优惠券")
                .type("1")
                .rule(null)
                .build();
        Map<Long, CouponTemplateInfo> map = new HashMap<>();
        map.put(1L,couponTemplateInfo);
        return map;

        //        log.info("接口被限流");
//        log.info(ids.toString());
//        log.info(exception.getMessage());
//        return Maps.newHashMap();
    }
    /**
     * 搜索模板
     *
     * @param request 搜索条件
     * @return {@link PagedCouponTemplateInfo}
     */
    @PostMapping("/search")
    public PagedCouponTemplateInfo search(@Valid @RequestBody TemplateSearchParams request) {
        log.info("search templates, payload={}", request);
        return couponTemplateService.search(request);
    }

    /**
     * 删除优惠券
     *
     * @param id 模板id
     */
    @DeleteMapping("/deleteTemplate")
    public void deleteTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id={}", id);
        couponTemplateService.deleteTemplate(id);
    }
}
