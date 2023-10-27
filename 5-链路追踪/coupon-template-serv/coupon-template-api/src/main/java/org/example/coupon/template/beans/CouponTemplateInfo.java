package org.example.coupon.template.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coupon.template.beans.rules.TemplateRule;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @description CouponTemplateInfo——封装优惠券模板的基本信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplateInfo {

    private Long id;

    @NotEmpty
    private String name;

    /**
     * 优惠券描述
     */
    @NotNull
    private String desc;

    /**
     * 优惠券类型
     */
    @NotNull
    private String type;

    /**
     * 适合门店 - 若无则为全店通用券
     */
    private Long shopId;
    /**
     * 优惠券规则
     */
    @NotNull
    private TemplateRule rule;

    /**
     * 当前模板是否为可用状态
     */
    private Boolean available;

}
