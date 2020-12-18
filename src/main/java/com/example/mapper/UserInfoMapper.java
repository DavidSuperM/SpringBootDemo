package com.example.mapper;

import com.example.entity.UserInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户信息表(UserInfo)表数据库访问层
 *
 * @author david
 * @since 2020-12-12 14:58:49
 */
@Repository
public interface UserInfoMapper {

    @Results(id="resultMap", value = {
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "age", property = "age"),
        @Result(column = "status", property = "status"),
        @Result(column = "version", property = "version"),
        @Result(column = "creator", property = "creator"),
        @Result(column = "update_user", property = "updateUser"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
    })
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id,name,age,status,version,creator,update_user,create_time,update_time from user_info where id = #{id} and status!=-1 ")
    UserInfoDO getById(@Param("id") Long id);
    
     /**
     * 得到总条数
     *
     * @return 总条数
     */
    @Select("select count(*) from user_info where status!=-1")
    int getTotalNumber();

    /**
     * 查询指定行数据
     *
     * @param from 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Select("select id,name,age,status,version,creator,update_user,create_time,update_time from user_info where status!=-1 limit #{from},#{limit}  ")
    List<UserInfoDO> getAllByLimit(@Param("from") int from, @Param("limit") int limit);
    
     /**
     * 通过实体作为筛选条件查询
     *
     * @param userInfoDO 实例对象
     * @return 对象列表
     */
    @Select("<script>" + 
        "select id,name,age,status,version,creator,update_user,create_time,update_time from user_info where 1=1 and status!=-1" + 
                "<if test='id != null'> and id = #{id} </if>" +
                "<if test='name != null'> and name = #{name} </if>" +
                "<if test='age != null'> and age = #{age} </if>" +
                "<if test='status != null'> and status = #{status} </if>" +
                "<if test='version != null'> and version = #{version} </if>" +
                "<if test='creator != null'> and creator = #{creator} </if>" +
                "<if test='updateUser != null'> and update_user = #{updateUser} </if>" +
                "<if test='createTime != null'> and create_time = #{createTime} </if>" +
                "<if test='updateTime != null'> and update_time = #{updateTime} </if>" +
                "</script>")
    List<UserInfoDO> getAllByCondition(UserInfoDO userInfoDO);

    /**
     * 分页+筛选查询
     *
     * @param userInfoDO 实例对象
     * @param from 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Select("<script>" + 
        "select id,name,age,status,version,creator,update_user,create_time,update_time from user_info where 1=1 and status!=-1" + 
                "<if test='userInfoDO.id != null'> and id = #{userInfoDO.id} </if>" +
                "<if test='userInfoDO.name != null'> and name = #{userInfoDO.name} </if>" +
                "<if test='userInfoDO.age != null'> and age = #{userInfoDO.age} </if>" +
                "<if test='userInfoDO.status != null'> and status = #{userInfoDO.status} </if>" +
                "<if test='userInfoDO.version != null'> and version = #{userInfoDO.version} </if>" +
                "<if test='userInfoDO.creator != null'> and creator = #{userInfoDO.creator} </if>" +
                "<if test='userInfoDO.updateUser != null'> and update_user = #{userInfoDO.updateUser} </if>" +
                "<if test='userInfoDO.createTime != null'> and create_time = #{userInfoDO.createTime} </if>" +
                "<if test='userInfoDO.updateTime != null'> and update_time = #{userInfoDO.updateTime} </if>" +
                " limit #{from},#{limit}"+
        "</script>")
    List<UserInfoDO> getAllByConditionLimit(@Param("userInfoDO")UserInfoDO userInfoDO, @Param("from")int from, @Param("limit")int limit);

    
    /**
     * 新增数据
     *
     * @param userInfoDO 实例对象
     * @return 影响行数
     */
    @Insert("insert into user_info(name, age, status, version, creator, update_user, create_time, update_time) "
    + "values (#{name}, #{age}, #{status}, #{version}, #{creator}, #{updateUser}, #{createTime}, #{updateTime})")
    int insert(UserInfoDO userInfoDO);
    
    /**
     * 批量新增数据
     *
     * @param userInfoDOList 实例对象
     * @return 影响行数
     */
    @Insert("<script> " + 
            "insert into user_info(name, age, status, version, creator, update_user, create_time, update_time) " + 
            "values " + 
            "<foreach collection='userInfoDOList' item='item' index='index' separator=','>" +
            "(#{item.name}, #{item.age}, #{item.status}, #{item.version}, #{item.creator}, #{item.updateUser}, #{item.createTime}, #{item.updateTime})" +
            "</foreach>" +
            "</script>")
    int insertList(@Param("userInfoDOList") List<UserInfoDO> userInfoDOList);

    /**
     * 修改数据
     *
     * @param userInfoDO 实例对象
     * @return 影响行数
     */
    @Update("<script> "+
    "update user_info set " +
        "<if test='name != null'> name = #{name},</if>"+
        "<if test='age != null'> age = #{age},</if>"+
        "<if test='status != null'> status = #{status},</if>"+
        "<if test='version != null'> version = #{version},</if>"+
        "<if test='creator != null'> creator = #{creator},</if>"+
        "<if test='updateUser != null'> update_user = #{updateUser},</if>"+
        "<if test='createTime != null'> create_time = #{createTime},</if>"+
        "<if test='updateTime != null'> update_time = #{updateTime},</if>"+
        "id = #{id} where id = #{id}" +
    "</script>")
    int update(UserInfoDO userInfoDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("update user_info set status=-1 where id = #{id}")
    int deleteById(@Param("id") Long id);
    
}