package top.yk.coupon.template.converter;


import top.yk.coupon.template.api.beans.CouponTemplateInfo;

/**
 * @author mqxu
 * @date 2023/9/8
 * @description CouponTemplateConverter
 **/
public class CouponTemplateConverter {

    public static CouponTemplateInfo convertToTemplateInfo(top.yk.coupon.template.dao.entity.CouponTemplate template) {

        return CouponTemplateInfo.builder()
                .id(template.getId())
                .name(template.getName())
                .desc(template.getDescription())
                .type(template.getCategory().getCode())
                .shopId(template.getShopId())
                .available(template.getAvailable())
                .rule(template.getRule())
                .build();
    }
}