package com.konai.hsyang.konatoy.file.controller;

import com.konai.hsyang.konatoy.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequiredArgsConstructor
@RestController
public class FileApiController {

    private final FileService fileService;

    @PostMapping("/api/file/upload")
    public String file(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

        fileService.insertFile(multipartHttpServletRequest);
        return "redirect:/posts/save";
    }
}
