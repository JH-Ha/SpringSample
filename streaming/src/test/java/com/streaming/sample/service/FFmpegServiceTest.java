package com.streaming.sample.service;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FFmpegServiceTest {

  @Autowired
  FFmpegService ffmpegService;

  @Test
  public void test() throws Exception {
    Path path = Paths.get("D://Movie/movie/時をかける少女_720p.mp4");
    ffmpegService.generateHlsFiles(path);
  }
}