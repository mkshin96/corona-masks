package me.mugon.coronamask.service;

import lombok.RequiredArgsConstructor;
import me.mugon.coronamask.controller.dto.MaskResponseDto;
import me.mugon.coronamask.domain.Store;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static me.mugon.coronamask.common.SettingInfo.URL;

@RequiredArgsConstructor
@Service
public class MaskService {

    private final RestTemplate restTemplate;

    public List<Store> getMasks(String address) {
        URI uri = UriComponentsBuilder.fromUriString(URL.getValue())
                .queryParam("address", address)
                .build()
                .encode()
                .toUri();
        MaskResponseDto responseDto = restTemplate.getForObject(uri, MaskResponseDto.class);
        if (responseDto.getStores() == null) {
            return new ArrayList<>();
        }
        return responseDto.getStores().stream()
                .map((store) -> {
                    if ("plenty".equals(store.getRemain_stat())) store.setRemain_stat("100개 이상");
                    if ("some".equals(store.getRemain_stat())) store.setRemain_stat("30개 ~ 100개");
                    if ("few".equals(store.getRemain_stat())) store.setRemain_stat("2개 ~ 30개");
                    if ("empty".equals(store.getRemain_stat())) store.setRemain_stat("1개 이하");
                    if ("break".equals(store.getRemain_stat())) store.setRemain_stat("판매 중지");
                    return store;
                }).collect(Collectors.toList());
    }
}
