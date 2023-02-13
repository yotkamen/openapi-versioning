package com.yotkamen.demoversioning.controller;

import com.yotkamen.demoversioning.controller.api.PonyApi;
import com.yotkamen.demoversioning.domain.api.PonyObject;
import com.yotkamen.demoversioning.domain.api.PonyObjectV1;
import com.yotkamen.demoversioning.domain.api.PonyObjectV2;
import com.yotkamen.demoversioning.domain.api.PonyResponse;
import com.yotkamen.demoversioning.domain.api.PonyResponseV1;
import com.yotkamen.demoversioning.domain.api.PonyResponseV2;

import lombok.val;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PonyController implements PonyApi {

    @Override
    public ResponseEntity<PonyResponse> ponyPost(PonyObject versionedParameter) {
        if (versionedParameter instanceof PonyObjectV1 uni) {
            return ponyPost(uni);
        } else if (versionedParameter instanceof PonyObjectV2 uni) {
            return ponyPost(uni);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PonyResponse> ponyPost(PonyObjectV1 pony) {
        val unicorn = new PonyResponseV1();
        unicorn.setName(pony.getName());
        unicorn.setVersionId(pony.getVersionId());
        unicorn.setWingsColors(pony.getWingsColors());
        return ResponseEntity.ok(unicorn);
    }

    public ResponseEntity<PonyResponse> ponyPost(PonyObjectV2 pony) {
        val pegasi = new PonyResponseV2();
        pegasi.setName(pony.getName());
        pegasi.setVersionId(pony.getVersionId());
        pegasi.setCornSize(pony.getCornSize());
        return ResponseEntity.ok(pegasi);
    }
}
