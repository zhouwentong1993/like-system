package com.wentong.countingservice.controller;

import com.wentong.countingservice.service.VideoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/{videoId}/{userId}/{op}")
    public String videoOp(@PathVariable Long videoId, @PathVariable Long userId, @PathVariable Integer op) {
        videoService.record(videoId, userId, op);
        return "success";
    }

    @GetMapping("top100")
    public String top100() {
        return videoService.top100();
    }



}
