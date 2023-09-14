package org.example.coupon.template.dao;

import org.example.coupon.template.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponDao extends JpaRepository<Coupon,Long> {

    Long countByUserIdAndTemplateId(Long userId,Long templateId);
}
