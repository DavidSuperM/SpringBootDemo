package com.example.controller;

import com.example.entity.UserInfoDO;
import com.example.service.RedisService;
import com.example.service.UserInfoService;
import com.example.component.ServiceResult;
import com.example.component.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户信息表(UserInfo)表控制层
 *
 * @author david
 * @since 2020-12-12 14:58:49
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    
    private final UserInfoService userInfoService;
    private final RedisService redisService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService
    ,RedisService redisService){
        this.userInfoService = userInfoService;
        this.redisService = redisService;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public MessageResult<UserInfoDO> getById (
        @RequestParam("id") Long id
) throws Exception{
        ServiceResult<UserInfoDO> serviceResult = userInfoService.getById(id);
        return MessageResult.create(serviceResult.getStatus(), serviceResult.getMsg(), serviceResult.getData());
    }

    /**
     * 插入
     * post情况下前端datatype是json，后端就用 @RequestBody 接收
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/insert")
    public MessageResult<Object> insert(
            @RequestBody UserInfoDO userInfoDO
    ) {
        ServiceResult<Object> serviceResult = userInfoService.insert(userInfoDO);
        return MessageResult.create(serviceResult.getStatus(), serviceResult.getMsg(), serviceResult.getData());
    }

    /**
     * 插入
     * post情况下前端datatype是form，后端就用 @RequestParam 接收
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/delete")
    public MessageResult<Object> delete(
            @RequestParam("id") Long id
    ) {
        ServiceResult<Object> serviceResult = userInfoService.deleteById(id);
        return MessageResult.create(serviceResult.getStatus(), serviceResult.getMsg(), serviceResult.getData());
    }

    /**
     * 测试redis
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/redis")
    public MessageResult<UserInfoDO> testRedis(
            @RequestParam("id") Long id
    ) {
        ServiceResult<UserInfoDO> serviceResult = redisService.getNameById(id);
        return MessageResult.create(serviceResult.getStatus(), serviceResult.getMsg(), serviceResult.getData());
    }

}