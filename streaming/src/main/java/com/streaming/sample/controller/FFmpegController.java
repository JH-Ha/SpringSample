package com.streaming.sample.controller;

import com.streaming.sample.service.FFmpegService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class FFmpegController {

  final FFmpegService ffmpegService;
  final Path UPLOADED_FOLDER = Paths.get("D://Movie/hls");

  @PostMapping("/upload")
  public ResponseEntity<Void> generateFiles(@RequestParam("file") MultipartFile file)
      throws Exception {
    if (!file.isEmpty()) {
      byte[] bytes = file.getBytes();
      Path path = UPLOADED_FOLDER.resolve(file.getOriginalFilename());
      Files.write(path, bytes);
      ffmpegService.generateHlsFiles(path);
      Files.delete(path);
    }

    return ResponseEntity.ok().build();
  }

  @GetMapping("/upload/view")
  public String uploadView() {
    return "upload";
  }
}
