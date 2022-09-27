package com.konai.hsyang.konatoy.file.util;

import com.konai.hsyang.konatoy.file.dto.FileSaveRequestDto;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {

    public List<FileSaveRequestDto> parseFileInfo(Posts posts, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            System.out.println("***************** No Files Detected ********************");
        }

        List<FileSaveRequestDto> fileList = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = "images/" + current.format(format);
        File file = new File(path);
        if (file.exists() == false)
            file.mkdirs();

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String saveFileName, originalFileExtension, contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                if (multipartFile.isEmpty() == false) {
                    contentType = multipartFile.getContentType();
                    if(ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else if(contentType.contains("image/jpeg")) {
                        originalFileExtension = ".jpg";
                    } else if(contentType.contains("image/png")) {
                        originalFileExtension = ".png";
                    } else if(contentType.contains("image/gif")) {
                        originalFileExtension = ".gif";
                    } else break;

                    saveFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    FileSaveRequestDto saveRequestDto = FileSaveRequestDto.builder()
                            .posts(posts)
                            .saveFileName(saveFileName)
                            .orgFileName(multipartFile.getOriginalFilename())
                            .fileSize(multipartFile.getSize())
                            .storePath(path + "/" + saveFileName)
                            .build();
                    fileList.add(saveRequestDto);

                    file = new File(path + "/" + saveFileName);
                    multipartFile.transferTo(file);
                }
            }
        }
        return fileList;
    }
}
