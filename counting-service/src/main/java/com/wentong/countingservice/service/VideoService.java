package com.wentong.countingservice.service;

import com.google.common.collect.Maps;
import com.wentong.countingservice.mapper.LikeRecordMapper;
import com.wentong.countingservice.vo.LikeRecord;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class VideoService {

    private final LikeRecordMapper likeRecordMapper;

    private final RocketMQTemplate rocketMQTemplate;

    public VideoService(LikeRecordMapper likeRecordMapper, RocketMQTemplate rocketMQTemplate) {
        this.likeRecordMapper = likeRecordMapper;
        this.rocketMQTemplate = rocketMQTemplate;
    }

    public void record(Long videoId, Long userId, Integer op) {
        LikeRecord likeRecord = new LikeRecord();
        likeRecord.setVideoId(videoId);
        likeRecord.setUserId(userId);
        likeRecord.setOp(op);
        rocketMQTemplate.asyncSend("like-topic", "abc", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("success");
            }

            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
//        Map<String, Object> map = Maps.newHashMapWithExpectedSize(3);
//        map.put("video_id", videoId);
//        map.put("user_id", userId);
//        map.put("op", op);
//        List<LikeRecord> likeRecords = likeRecordMapper.selectByMap(map);
//        if (likeRecords == null || likeRecords.isEmpty()) {
//            LikeRecord likeRecord = new LikeRecord();
//            likeRecord.setVideoId(videoId);
//            likeRecord.setOp(op);
//            likeRecord.setUserId(userId);
//            likeRecord.setCreateTime(new Date());
//            likeRecordMapper.insert(likeRecord);
//        }
    }

    public String top100() {
        return likeRecordMapper.topNLikedRecord(100).toString();
    }
}
