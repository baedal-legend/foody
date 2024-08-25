package com.sparta.baedallegend.shop.domain;

public enum ShopStatus {
    OPEN("영업 중"), CLOSED("영업 종료"), BREAK_TIME("재료 준비 시간");

    private final String description;

    private ShopStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
