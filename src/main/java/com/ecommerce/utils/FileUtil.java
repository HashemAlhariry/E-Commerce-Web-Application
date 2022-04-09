package com.ecommerce.utils;

import jakarta.servlet.http.Part;

import java.util.Optional;

public class FileUtil {
    private static final FileUtil INSTANCE=new FileUtil();
    private FileUtil(){

    }
    public static FileUtil getINSTANCE() {
        return INSTANCE;
    }
    public Optional<String> getFileName(Part filePart){
        for (String content : filePart.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return Optional.of(content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", ""));
            }
        }
        return Optional.empty();
    }
}
