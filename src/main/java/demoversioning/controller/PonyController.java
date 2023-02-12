package demoversioning.controller;

import demoversioning.controller.api.PonyApi;
import demoversioning.domain.api.PonyObject;
import demoversioning.domain.api.PonyObjectV1;
import demoversioning.domain.api.PonyObjectV2;
import demoversioning.domain.api.PonyResponse;
import demoversioning.domain.api.PonyResponseV1;
import demoversioning.domain.api.PonyResponseV2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PonyController implements PonyApi {

    @Override
    public ResponseEntity<PonyResponse> ponyPost(PonyObject versionedParameter) {
        if (versionedParameter instanceof PonyObjectV1 uni) {
            return postUsingPOST(uni);
        } else if (versionedParameter instanceof PonyObjectV2 uni) {
            return postUsingPOST(uni);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<PonyResponse> postUsingPOST(PonyObjectV1 v1Response) {
        final PonyResponseV1 unicorn = new PonyResponseV1();
        unicorn.setName(v1Response.getName());
        unicorn.setVersionId(v1Response.getVersionId());
        unicorn.setWingsColors(v1Response.getWingsColors());
        return ResponseEntity.ok(unicorn);
    }

    public ResponseEntity<PonyResponse> postUsingPOST(PonyObjectV2 v2Response) {
        final PonyResponseV2 pegasi = new PonyResponseV2();
        pegasi.setName(v2Response.getName());
        pegasi.setVersionId(v2Response.getVersionId());
        pegasi.setCornSize(v2Response.getCornSize());
        return ResponseEntity.ok(pegasi);
    }
}
