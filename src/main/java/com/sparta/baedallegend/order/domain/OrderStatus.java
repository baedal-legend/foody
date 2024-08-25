package com.sparta.baedallegend.order.domain;

public enum OrderStatus {
    ORDER_COMPLETE("주문완료") ,CANCELED("취소됨") ,COOKING("조리중") , DELIVERING("배달중") , DELIVERED("배달완료");

    private final String description;

    OrderStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
