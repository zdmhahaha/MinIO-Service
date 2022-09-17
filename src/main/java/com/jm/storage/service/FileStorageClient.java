package com.jm.storage.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件存储接口
 *
 * @author zhanghongbin
 */
public interface FileStorageClient {

    public List<String> upload(List<MultipartFile> files);

    public List<Boolean> delete(List<String> fileName);
}
