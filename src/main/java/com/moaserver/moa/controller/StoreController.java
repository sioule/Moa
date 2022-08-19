package com.moaserver.moa.controller;

import com.moaserver.moa.entity.store.Store;
import com.moaserver.moa.entity.store.StoreDto;
import com.moaserver.moa.service.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    //마일리지 사용처 등록
    @PostMapping("/store")
    public ResponseEntity<Store> location(@RequestBody StoreDto storeDto) {
        Store store = storeService.save(storeDto);
        return new ResponseEntity(storeDto, HttpStatus.CREATED);
    }

    //주변 사용처 찾기
    @GetMapping("/store/{memberid}")
    public ResponseEntity<Store> location(@PathVariable Long memberId) {
        storeService.findNearBy(memberId);


        return new ResponseEntity(HttpStatus.CREATED);
    }

}
