package org.example.coupon.template.api.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coupon.template.beans.CouponInfo;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationOrder {

    @NotEmpty
    private List<Product> products;

    @NotEmpty
    private List<Long> couponIDs;

    private List<CouponInfo> couponInfos;

    @NotEmpty
    private Long userId;
}
