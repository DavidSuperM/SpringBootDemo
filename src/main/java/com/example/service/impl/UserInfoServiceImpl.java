package com.example.service.impl;

import com.example.entity.UserInfoDO;
import com.example.entity.dto.UserInfoListDTO;
import com.example.mapper.UserInfoMapper;
import com.example.service.UserInfoService;
import com.example.component.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author david
 * @since 2020-12-12 15:01:55
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    
    private final UserInfoMapper userInfoMapper;
    
    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper){
        this.userInfoMapper = userInfoMapper;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
//    @Retryable(value = RemoteAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    @Retryable(value = RemoteAccessException.class)
    public ServiceResult<UserInfoDO> getById(Long id) throws Exception{
        UserInfoDO userInfo = userInfoMapper.getById(id);
        if(userInfo==null){
            throw new RemoteAccessException("111");
        }
        return ServiceResult.createSuccessResult(userInfo);
    }

    /**
     * 查询多条数据
     *
     * @param currentPage 当前页
     * @param pageSize 一页大小
     * @return 对象列表
     */
    @Override
    public ServiceResult<UserInfoListDTO> getAllByPage(int currentPage, int pageSize) {
        int count = userInfoMapper.getTotalNumber();
        List<UserInfoDO> UserInfoDOList =  userInfoMapper.getAllByLimit((currentPage-1)*pageSize, pageSize);
        UserInfoListDTO userInfoDOListDTO = UserInfoListDTO.builder()
            .count(count)
            .UserInfoList(UserInfoDOList)
            .build();
        return ServiceResult.createSuccessResult(userInfoDOListDTO);
    }
    
    /**
     * 条件+分页查询
     *
     * @param userInfoDO 条件
     * @param currentPage 当前页
     * @param pageSize 一页大小
     * @return 对象列表
     */
    @Override
    public ServiceResult<UserInfoListDTO> getAllByPageCondition(UserInfoDO userInfoDO, int currentPage, int pageSize) {
        int count = userInfoMapper.getTotalNumber();
        List<UserInfoDO> UserInfoDOList = userInfoMapper.getAllByConditionLimit(userInfoDO, (currentPage-1)*pageSize, pageSize);
        UserInfoListDTO userInfoListDTO = UserInfoListDTO.builder()
            .count(count)
            .UserInfoList(UserInfoDOList)
            .build();
        return ServiceResult.createSuccessResult(userInfoListDTO);
    }

    /**
     * 新增数据
     *
     * @param userInfoDO 实例对象
     * @return 
     */
    @Override
    public ServiceResult<Object> insert(UserInfoDO userInfoDO) {
        userInfoDO.setCreateTime(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0));
        userInfoMapper.insert(userInfoDO);
        return ServiceResult.createSuccessResult();
    }
    
    /**
     * 新增数据
     *
     * @param userInfoDOList 实例对象
     * @return 
     */
    @Override
    public ServiceResult<Object> insertList(List<UserInfoDO> userInfoDOList) {
        userInfoMapper.insertList(userInfoDOList);
        return ServiceResult.createSuccessResult();
    }

    /**
     * 修改数据
     *
     * @param userInfoDO 实例对象
     * @return 
     */
    @Override
    public ServiceResult<Object> update(UserInfoDO userInfoDO) {
        userInfoMapper.update(userInfoDO);
        return ServiceResult.createSuccessResult(); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 
     */
    @Override
    public ServiceResult<Object> deleteById(Long id) {
        userInfoMapper.deleteById(id);
        return ServiceResult.createSuccessResult(); 
    }
}