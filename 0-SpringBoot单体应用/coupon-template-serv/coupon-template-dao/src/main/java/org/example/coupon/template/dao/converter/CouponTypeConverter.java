package org.example.coupon.template.dao.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.coupon.template.enums.CouponType;

@Converter
public class CouponTypeConverter implements AttributeConverter<CouponType, String> {

    @Override
    public String convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
