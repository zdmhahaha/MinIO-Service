package com.jm.storage.controller;

import com.jm.storage.service.FileStorageClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author zhanghongbin
 */
@RestController
@RequestMapping("/storage")
public class FileStorageController {

    @Resource
    private FileStorageClient fileStorageClient;

    /**
     * 多文件上传
     *
     * @param files
     * @return
     */
    @PostMapping("/upload")
    public List<String> upload(@RequestParam("files") List<MultipartFile> files) {
        return fileStorageClient.upload(files);
    }

    /**
     * 文件删除
     *
     * @param filesName 文件名
     */
    @PostMapping("/delete")
    public List<Boolean> delete(@RequestParam("filesName") List<String> filesName) {
        return fileStorageClient.delete(filesName);
    }
}
