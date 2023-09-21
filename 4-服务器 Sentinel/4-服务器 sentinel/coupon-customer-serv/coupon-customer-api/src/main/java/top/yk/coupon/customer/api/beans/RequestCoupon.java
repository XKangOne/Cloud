package top.yk.coupon.customer.api.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {

    @NotNull
    private Long userId;

    @NotNull
    private Long couponTemplateId;
}
