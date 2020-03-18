package me.mugon.coronamask.service;

import lombok.RequiredArgsConstructor;
import me.mugon.coronamask.controller.dto.MaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static me.mugon.coronamask.common.SettingInfo.URL;

@RequiredArgsConstructor
@Service
public class MaskService {

    private final RestTemplate restTemplate;

    public ResponseEntity<?> getMasks(String address) {
        URI uri = UriComponentsBuilder.fromUriString(URL.getValue())
                .queryParam("address", address)
                .build()
                .encode()
                .toUri();
        
        return restTemplate.getForEntity(uri, MaskResponseDto.class);
    }
}
