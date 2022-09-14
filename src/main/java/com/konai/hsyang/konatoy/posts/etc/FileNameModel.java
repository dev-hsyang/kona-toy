package com.konai.hsyang.konatoy.posts.etc;

import lombok.NoArgsConstructor;

import java.util.Calendar;

@NoArgsConstructor
public class FileNameModel {

    public String GenSaveFileName(String extName) {

        String fileName = "";

        Calendar calendar = Calendar.getInstance();
        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);
        fileName += extName;

        return fileName;
    }
}
