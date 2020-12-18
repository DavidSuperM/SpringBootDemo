package com.example.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author david
 * @since 2020-12-12 14:58:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * ID
    */
    private Long id;
    /**
    * 名字
    */
    private String name;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 状态 -1:删除 0:正常
    */
    private Integer status;
    /**
    * 版本
    */
    private Integer version;
    /**
    * 创建人
    */
    private String creator;
    /**
    * 修改人
    */
    private String updateUser;
    /**
    * 创建时间
     * @JsonFormat 以特定格式输出到前端或接收前端特定格式输入
    */
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;


}