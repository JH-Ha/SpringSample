package com.streaming.sample.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideoController {

  Path hlsDir = Paths.get("D://Movie/hls/");

  @GetMapping("/video/view")
  public String view() {
    return "video";
  }

  @GetMapping("/playlist/{fileName}")
  public ResponseEntity<Resource> getTsFile(@PathVariable String fileName) {
    Path tsFilePath = hlsDir.resolve(fileName);
    Resource tsFile = null;
    try {
      tsFile = new UrlResource(tsFilePath.toUri());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_TYPE, "video/MP2T")
        .body(tsFile);
  }
}
