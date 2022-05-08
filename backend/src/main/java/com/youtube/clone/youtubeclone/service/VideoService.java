package com.youtube.clone.youtubeclone.service;

import com.youtube.clone.youtubeclone.model.Video;
import com.youtube.clone.youtubeclone.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private  final VideoRepository videoRepository;

    public void uploadVideo(MultipartFile multipartFile){
        String videoUrl=s3Service.uploadFile(multipartFile);
        var video=new Video();
        video.setVideourl(videoUrl);


        videoRepository.save(video);
    }
}
