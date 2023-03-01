package com.ayoh.coreshop.entity.product;

public enum ProductSellStatus {

    FOR_SALE("판매중"),
    SOLD_OUT("매진");

    private final String koreanName;

    ProductSellStatus(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public static ProductSellStatus of(String dbData) {
        return null;
    }

}
