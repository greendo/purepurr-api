package com.purepurr.apiservice.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class GlassesController {

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(String param) throws IOException {

        File file = null;
        //TODO: GET FILE FROM HADOOP https://creativedata.atlassian.net/wiki/spaces/SAP/pages/52199514/Java+-+Read+Write+files+with+HDFS

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
