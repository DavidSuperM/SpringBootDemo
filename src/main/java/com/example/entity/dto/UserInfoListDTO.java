package com.example.entity.dto;

import java.time.LocalDateTime;
import com.example.entity.UserInfoDO;
import java.io.Serializable;
import lombok.*;
import java.util.List;

/**
 * 用户信息表(UserInfo)传输类
 *
 * @author david
 * @since 2020-12-12 14:58:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserInfoListDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer count;
    
    private List<UserInfoDO> UserInfoList;

}