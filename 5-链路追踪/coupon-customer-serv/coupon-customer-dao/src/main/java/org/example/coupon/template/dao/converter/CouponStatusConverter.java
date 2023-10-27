package org.example.coupon.template.dao.converter;


import org.example.coupon.template.api.enums.CouponStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * @author mqxu
 * @date 2023/9/8
 * @description CouponStatusConverter
 **/
@Converter
public class CouponStatusConverter implements AttributeConverter<CouponStatus, Integer> {

    /**
     * enum 转 DB value
     *
     * @param status enum
     * @return Integer
     */
    @Override
    public Integer convertToDatabaseColumn(CouponStatus status) {
        return status.getCode();
    }

    /**
     * DB value 转 enum 值
     *
     * @param code DB value
     * @return CouponStatus
     */
    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.convert(code);
    }
}