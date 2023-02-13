package com.yotkamen.demoversioning.controller;

import org.springframework.web.bind.annotation.RestController;

import com.yotkamen.demoversioning.controller.api.V2Api;

import com.yotkamen.demoversioning.domain.api.FishObjectV2;
import com.yotkamen.demoversioning.domain.api.FishResponseV2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class FishControllerV2 implements V2Api {

    @Override
    public ResponseEntity<FishResponseV2> fishPostV2(FishObjectV2 fishObjectV2) {
        final FishResponseV2 pegasi = new FishResponseV2();
        pegasi.setName(fishObjectV2.getName());
        pegasi.setCornSize(fishObjectV2.getCornSize());
        return ResponseEntity.ok(pegasi);
    }
}
