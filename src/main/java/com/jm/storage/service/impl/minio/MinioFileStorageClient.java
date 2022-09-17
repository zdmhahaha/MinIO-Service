package com.jm.storage.service.impl.minio;

import com.jm.storage.config.minio.MinioStorageProperties;
import com.jm.storage.service.BucketName;
import com.jm.storage.service.FileStorageClient;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * minio存储实现类
 *
 * @author zhanghongbin
 */
@RequiredArgsConstructor
public class MinioFileStorageClient implements FileStorageClient {

    private final MinioClient minioClient;

    @Resource
    private MinioStorageProperties minioStorageProperties;

    @Override
    public List<String> upload(List<MultipartFile> files) {
        List<String> urlList = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String bucketName = this.getBucketName(file.getContentType());
            try {
                PutObjectArgs args = PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build();
                minioClient.putObject(args);
                String url = minioStorageProperties.getUrl() + "/" + bucketName + "/" + fileName;
                urlList.add(url);
            } catch (Exception e) {
                urlList.add("");
            }
        }
        return urlList;
    }

    @Override
    public List<Boolean> delete(List<String> fileNames) {
        List<Boolean> result = new ArrayList<>();
        for (String fileName : fileNames) {
            try {
                String bucketName = this.getBucketName(Files.probeContentType(new File(fileName).toPath()));
                minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build());
                result.add(true);
            } catch (Exception e) {
                result.add(false);
            }
        }
        return result;
    }

    private String getBucketName(String mime){
        String bucketName = BucketName.FILE.toString();
        if (mime.contains(BucketName.IMAGE.toString())) {
            bucketName = BucketName.IMAGE.toString();
        } else if (mime.contains(BucketName.VIDEO.toString())) {
            bucketName = BucketName.VIDEO.toString();
        }
        return bucketName;
    }

}
