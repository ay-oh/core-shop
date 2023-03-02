package com.ayoh.coreshop.dto.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductCreateRequest {

    private final String name;
    private final Integer price;
    private final Integer stockNumber;
    private final String details;
    private final String sellStatus;
    private final String createdBy;


    public static ProductCreateRequest empty() {
        return new ProductCreateRequest(null, null, null, null, null, null);
    }

}
