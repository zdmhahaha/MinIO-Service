package com.jm.storage.service.impl.minio;

import com.jm.storage.service.FileStorageClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileStorageClientTest {

    @Autowired
    private FileStorageClient fileStorageClient;
    @Test
    void delete() {
        List<String> fileName = new ArrayList<>();
        fileName.add("阿里巴巴Java开发手册终极版v1.3.0.pdf");
        fileStorageClient.delete(fileName);
    }
}