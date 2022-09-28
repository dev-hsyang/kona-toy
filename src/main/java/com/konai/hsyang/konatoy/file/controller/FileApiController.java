package com.konai.hsyang.konatoy.file.controller;

import com.konai.hsyang.konatoy.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequiredArgsConstructor
@RestController
public class FileApiController {

    private final FileService fileService;

    @PostMapping("/api/file/showInfo")
    public String file(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

        fileService.fileInfo(multipartHttpServletRequest);
        return "redirect:/posts/save";
    }

    @PostMapping("/api/file/upload/{postsID}")
    public String uploadFile(@PathVariable Long postsID, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

        fileService.uploadFile(multipartHttpServletRequest, postsID);
        return "complete";
    }
}
