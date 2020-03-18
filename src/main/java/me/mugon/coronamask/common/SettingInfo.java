package me.mugon.coronamask.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum SettingInfo {
    URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json");

    private String value;
}
