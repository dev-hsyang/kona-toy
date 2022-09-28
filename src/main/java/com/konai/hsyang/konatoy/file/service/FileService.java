package com.konai.hsyang.konatoy.file.service;

import com.konai.hsyang.konatoy.exceptions.NoPostsFoundException;
import com.konai.hsyang.konatoy.file.dto.FileSaveRequestDto;
import com.konai.hsyang.konatoy.file.repository.FileRepository;
import com.konai.hsyang.konatoy.file.util.FileUtils;
import com.konai.hsyang.konatoy.posts.domain.Posts;
import com.konai.hsyang.konatoy.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileUtils fileUtils;
    private final FileRepository fileRepository;

    public void fileInfo(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

        if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            String tag;
            while(iterator.hasNext()) {
                tag = iterator.next();
                System.out.println("file tag name : " + tag);
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(tag);
                for(MultipartFile multipartFile : list) {
                    System.out.println("\nstart file information");
                    System.out.println("file name: " + multipartFile.getOriginalFilename());
                    System.out.println("file size: " + multipartFile.getSize());
                    System.out.println("file content type: " + multipartFile.getContentType());
                    System.out.println("end file information \n");
                }
            }
        }
    }

    public void uploadFile(MultipartHttpServletRequest multipartHttpServletRequest, Long postsID) throws Exception {

        List<FileSaveRequestDto> filelist = fileUtils.parseFileInfo(postsID, multipartHttpServletRequest);

        for(FileSaveRequestDto requestDto : filelist) {
            fileRepository.save(requestDto.toEntity());
        }
    }
}
