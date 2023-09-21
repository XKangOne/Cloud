package top.yk.coupon.calculation.api.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.yk.coupon.template.api.beans.CouponInfo;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private List<Product> products;

    private Long couponId;

    private long cost;

    private List<CouponInfo> couponInfos;

    @NotNull
    private Long userId;
}
