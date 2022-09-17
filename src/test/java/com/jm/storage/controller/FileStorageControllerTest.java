package com.jm.storage.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FileStorageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void upload() throws Exception {
        File file2 = new File("C:\\Users\\PC\\Desktop\\新建文本文档.txt");
        MockMultipartFile mFile2 = new MockMultipartFile("files", "a.txt",
                MediaType.TEXT_PLAIN_VALUE, new FileInputStream(file2));

        MockMultipartFile mFile3 = new MockMultipartFile("files", "a.txt",
                MediaType.TEXT_PLAIN_VALUE, new FileInputStream(file2));
        MvcResult mvcResult = mockMvc.perform(multipart("/storage/upload")
                        .file(mFile2).file(mFile3))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println(content);

    }
}