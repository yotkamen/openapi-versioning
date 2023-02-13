package com.yotkamen.demoversioning.controller;

import org.springframework.web.bind.annotation.RestController;

import com.yotkamen.demoversioning.controller.api.V1Api;

import com.yotkamen.demoversioning.domain.api.FishObjectV1;
import com.yotkamen.demoversioning.domain.api.FishResponseV1;
import org.springframework.http.ResponseEntity;

@RestController
public class FishControllerV1 implements V1Api {

    @Override
    public ResponseEntity<FishResponseV1> fishPostV1(FishObjectV1 fish) {
        final FishResponseV1 unicorn = new FishResponseV1();
        unicorn.setName(fish.getName());
        unicorn.setWingsColors(fish.getWingsColors());
        return ResponseEntity.ok(unicorn);
    }
}
