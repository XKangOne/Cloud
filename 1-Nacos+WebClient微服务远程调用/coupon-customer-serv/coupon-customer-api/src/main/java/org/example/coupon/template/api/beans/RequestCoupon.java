package org.example.coupon.template.api.beans;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.PrimitiveIterator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {

    //用户领券
    @NotNull
    private Long userId;

    //券模板ID
    @NotNull
    private Long couponTemplateId;

    /*
    * Loadbalancer - 用作测试流量打标
    * */
    private String trafficVersion;
}
