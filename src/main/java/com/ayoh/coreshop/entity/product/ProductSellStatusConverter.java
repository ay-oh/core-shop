package com.ayoh.coreshop.entity.product;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductSellStatusConverter implements AttributeConverter<ProductSellStatus, String> {

    @Override
    public String convertToDatabaseColumn(ProductSellStatus attribute) {
        return attribute.name();
    }

    @Override
    public ProductSellStatus convertToEntityAttribute(String dbData) {
        return ProductSellStatus.of(dbData);
    }

}
