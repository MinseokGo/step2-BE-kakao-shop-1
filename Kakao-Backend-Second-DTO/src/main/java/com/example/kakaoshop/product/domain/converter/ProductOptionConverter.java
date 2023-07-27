package com.example.kakaoshop.product.domain.converter;

import com.example.kakaoshop.product.domain.model.ProductOption;
import com.example.kakaoshop.product.entity.ProductOptionEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductOptionConverter {
    public static ProductOption from(ProductOptionEntity entity) {
        if (entity == null) {
            return null;
        }

        return ProductOption.builder()
                .id(entity.getProductOptionId())
                .price(entity.getPrice())
                .optionName(entity.getOptionName())
                .product(ProductConverter.from(entity.getProduct()))
                .build();
    }

    public static ProductOptionEntity to(ProductOption productOption) {
        if (productOption == null) {
            return null;
        }
        return ProductOptionEntity.builder()
                .productOptionId(productOption.getId())
                .price(productOption.getPrice())
                .optionName(productOption.getOptionName())
                .product(ProductConverter.to(productOption.getProduct()))
                .build();
    }
}
