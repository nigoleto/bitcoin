package com.example.bitcoin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter //클래스의 포함된 멤버 변수의 모든 getter 매서드를 생성
@Setter
@Builder // sql에 값 넣는것
@ToString // 객체의 값 확인
@AllArgsConstructor //생성자 자동 완성  // 이걸쓰면 밑에 CoinKindEntity Builder로 생성자 생성을 안해도되는듯
@NoArgsConstructor //생성자 자동 완성
public class CoinKindDTO {
    @JsonProperty("market")
    private String market;

    @JsonProperty("korean_name")
    private String koreanName;

    @JsonProperty("english_name")
    private String englishName;

    @JsonProperty("market_warning")
    private String marketWarning;
}
