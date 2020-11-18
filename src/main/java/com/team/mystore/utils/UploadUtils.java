package com.team.mystore.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UploadUtils {
    public static String upload(MultipartFile part,  String path) throws IOException {
        System.out.println("uploadRootPath=" + path);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String strDate = dateFormat.format(date);


        File uploadRootDir = new File(path);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        String fileName = strDate+part.getOriginalFilename().replaceAll("\\s", "_");
        File file= new File(path +"/"+ fileName);
        try(InputStream is = part.getInputStream()){
            try(OutputStream os = new FileOutputStream(file)){
                int len = 0;
                byte[] bytes = new byte[1024];
                while ( ( len = is.read(bytes, 0, 1024)) > 0) {
                    os.write(bytes, 0, len);
                }
            }
        }
        return fileName;
    }
}
