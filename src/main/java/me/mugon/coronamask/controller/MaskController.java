package me.mugon.coronamask.controller;

import lombok.RequiredArgsConstructor;
import me.mugon.coronamask.domain.Store;
import me.mugon.coronamask.service.MaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MaskController {

    private final MaskService maskService;

    /*
    검색 기준이 될 주소
    예) '서울특별시 강남구' or '서울특별시 강남구 논현동'
    ('서울특별시' 와 같이 '시'단위만 입력하는 것은 불가능합니다.)
     */
    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/api/masks")
    public String getMasks(Model model, @RequestParam(value = "address", required = false) String address) {
        List<Store> masks = maskService.getMasks(address);
        if (masks != null) {
            model.addAttribute("masks", masks);
        }
        return "index";
    }
}
