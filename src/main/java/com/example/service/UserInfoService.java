package com.example.service;

import com.example.entity.UserInfoDO;
import com.example.component.ServiceResult;
import com.example.entity.dto.UserInfoListDTO;
import java.util.List;

/**
 * 用户信息表(UserInfo)表服务接口
 *
 * @author david
 * @since 2020-12-12 14:58:49
 */
public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ServiceResult<UserInfoDO> getById(Long id) throws Exception;
    
    /**
     * 查询多条数据
     *
     * @param currentPage 当前页
     * @param pageSize 一页大小
     * @return 
     */
    ServiceResult<UserInfoListDTO> getAllByPage(int currentPage, int pageSize);
    
    /**
     *  条件+分页查询
     *
     * @param userInfoDO 条件
     * @param currentPage 当前页
     * @param pageSize 一页大小
     * @return 
     */
    ServiceResult<UserInfoListDTO> getAllByPageCondition(UserInfoDO userInfoDO, int currentPage, int pageSize);

    /**
     * 新增数据
     *
     * @param userInfoDO 实例对象
     * @return 
     */
    ServiceResult<Object> insert(UserInfoDO userInfoDO);
    
     /**
     * 批量新增数据
     *
     * @param userInfoDOList 实例对象
     * @return 
     */
    ServiceResult<Object> insertList(List<UserInfoDO> userInfoDOList);

    /**
     * 修改数据
     *
     * @param userInfoDO 实例对象
     * @return 
     */
    ServiceResult<Object> update(UserInfoDO userInfoDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 
     */
    ServiceResult<Object> deleteById(Long id);

}