package com.jm.storage.config.minio;

import com.jm.storage.service.impl.minio.MinioFileStorageClient;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio配置类
 *
 * @author zhanghongbin
 */
@Configuration
public class MinioStorageConfiguration {

    @Bean
    public MinioFileStorageClient minioFileStorageClient(MinioStorageProperties minioStorageProperties) {
        MinioClient minioClient = MinioClient.builder().endpoint(minioStorageProperties.getUrl()).
                credentials(minioStorageProperties.getAccessKey(), minioStorageProperties.getSecretKey()).build();
        return new MinioFileStorageClient(minioClient);
    }
}
