package org.example.coupon.template.dao.converter;

import com.alibaba.fastjson.JSON;
import org.example.coupon.template.beans.rules.TemplateRule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * RuleConverter
 */

@Converter
public class RuleConverter implements AttributeConverter<TemplateRule,String> {

    @Override
    public String convertToDatabaseColumn(TemplateRule rule) {
        return JSON.toJSONString(rule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule,TemplateRule.class);
    }
}
