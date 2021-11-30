package com.wentong.consumingservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wentong.consumingservice.vo.LikeRecord;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRecordMapper extends BaseMapper<LikeRecord> {

    @Select("select video_id from like_record group by video_id order by sum(IF(op = 1, 1, -1)) desc limit #{n}")
    List<Long> topNLikedRecord(int n);

}
