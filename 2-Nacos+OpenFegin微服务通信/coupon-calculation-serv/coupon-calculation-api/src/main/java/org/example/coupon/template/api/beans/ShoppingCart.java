package org.example.coupon.template.api.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coupon.template.beans.CouponInfo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @NotEmpty
    private List<Product> products;

    private Long couponId;

    private Long cost;

    /**
     * 目前只支持单张优惠券，为了以后的扩展考虑，可以添加多个优惠券的计算逻辑，所以用List
     */
    private List<CouponInfo> couponInfos;

    @NotNull
    private Long userId;
}
