package me.mugon.coronamask.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.mugon.coronamask.domain.Store;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MaskResponseDto {
    private String address;
    private Integer count;
    private List<Store> stores = new ArrayList<>();
}
