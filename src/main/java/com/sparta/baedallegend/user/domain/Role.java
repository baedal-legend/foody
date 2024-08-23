package com.sparta.baedallegend.user.domain;

public enum Role {
    //- **고객:** 자신의 주문 내역만 조회 가능
    //- **가게 주인:** 자신의 가게 주문 내역, 가게 정보, 주문 처리 및 메뉴 수정 가능
    //- **관리자:** 모든 가게 및 주문에 대한 전체 권한 보유
     OWNER, CUSTOMER, MASTER
}
