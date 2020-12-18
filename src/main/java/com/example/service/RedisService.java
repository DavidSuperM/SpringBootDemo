package com.example.service;

import com.example.component.ServiceResult;
import com.example.entity.UserInfoDO;

/**
 * @author david
 */
public interface RedisService {

    /**
     * 得到名字
     * @param id
     * @return
     */
    ServiceResult<UserInfoDO> getNameById(Long id);
}
