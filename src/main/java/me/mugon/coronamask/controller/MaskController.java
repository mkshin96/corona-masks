package me.mugon.coronamask.controller;

import lombok.RequiredArgsConstructor;
import me.mugon.coronamask.service.MaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/api")
@RestController
public class MaskController {

    private final MaskService maskService;

    /*
    검색 기준이 될 주소
    예) '서울특별시 강남구' or '서울특별시 강남구 논현동'
    ('서울특별시' 와 같이 '시'단위만 입력하는 것은 불가능합니다.)
     */
    @GetMapping("/masks")
    public ResponseEntity<?> getMasks(@RequestParam("address") String address) {
        return maskService.getMasks(address);
    }
}
