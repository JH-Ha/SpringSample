package com.streaming.sample.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.bytedeco.javacpp.Loader;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FFmpegService {

  private FFmpeg ffmpeg;
  private Path outputDir;

  public FFmpegService() throws Exception {
    ffmpeg = new FFmpeg(Loader.load(org.bytedeco.ffmpeg.ffmpeg.class));
    ffmpeg = new FFmpeg(Loader.load(org.bytedeco.ffmpeg.ffmpeg.class));
    outputDir = Paths.get("D://Movie/hls/");

  }

  public void generateHlsFiles(Path path) throws Exception {
    FFmpegBuilder builder = ffmpeg.builder()
        .setInput(path.toAbsolutePath().toString()) // 동영상파일
        .addOutput(outputDir.toAbsolutePath().resolve( path.getFileName() + ".m3u8").toString())
//        .addExtraArgs("-profile:v", "baseline")
//        .addExtraArgs("-level", "3.0")
//        .addExtraArgs("-start_number", "0")
        .addExtraArgs("-hls_time", "10")
        .addExtraArgs("-hls_list_size", "0")
        .addExtraArgs("-f", "hls")
        .done();

    //ffmpeg -i small.mp4 -g 60 -hls_time 2 -hls_list_size 0 -hls_segment_size 500000 output.m3u8

    FFmpegExecutor executor = new FFmpegExecutor(ffmpeg);
    executor.createJob(builder).run();
  }
}
