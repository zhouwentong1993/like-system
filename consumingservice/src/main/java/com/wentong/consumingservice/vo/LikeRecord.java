package com.wentong.consumingservice.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LikeRecord implements Serializable {
    @TableId(type= IdType.AUTO)
    private Long id;
    private Long userId;
    private Long videoId;
    // 操作：1->like，0->dislike
    private Integer op;
    private Date createTime;
}
