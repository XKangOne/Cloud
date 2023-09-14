package org.example.coupon.template.beans;

/*
* PagedCouponTemplateInfo --封装分页信息
* */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagedCouponTemplateInfo {

    public List<CouponTemplateInfo> templates;

    public int page;

    public long total;
}
