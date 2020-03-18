package me.mugon.coronamask.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Store {
    private String addr; //판매처 주소
    private String code; //식별코드
    private String created_at; //데이터 생성일자
    private String remain_stat; //재고상태, 100개 이상(녹색): 'plenty', 30개 이상    100개 미만(노랑색) : 'some', 2개 이상 30개 이하
    private String stock_at; //입고시간
    private float lat; //위도
    private float lng; //경도
    private String name;
    private String type; //약국:'01', 우체국: '02', 농협: '03'
}
