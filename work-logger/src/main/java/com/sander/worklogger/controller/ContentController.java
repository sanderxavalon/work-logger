package com.sander.worklogger.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ContentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @GetMapping(
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/221002.jpg");
        return IOUtils.toByteArray(in);
    }
    @PostMapping("/upload-test")
    public String uploadfile(@RequestParam("file") MultipartFile file, @RequestParam("number") String number) throws IOException {
        logger.info(file.getContentType());
        logger.info(file.getOriginalFilename());
        logger.info(file.getBytes().toString());
        logger.info(number);
        return "get-image-with-media-type";
    }
}
