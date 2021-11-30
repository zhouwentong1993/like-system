package com.wentong.countingservice.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Video {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String title;
    private String url;
    private Date createTime;
}
