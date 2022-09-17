package com.jm.storage.config.minio;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhanghongbin
 */
@Data
@Component
@ConfigurationProperties(prefix = "storage.minio")
public class MinioStorageProperties {

    private String url;
    private String accessKey;
    private String secretKey;
}
