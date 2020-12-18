//package com.example.controller;
//
//import com.example.entity.UserInfoDO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//
//
///**
// * 用户信息表(UserInfo)表控制层
// *
// * @author david
// * @since 2020-12-05 21:35:21
// */
//@RestController
//@RequestMapping("/userInfo")
//public class UserInfoController2 {
//
//    private final UserInfoService userInfoService;
//
//    @Autowired
//    public UserInfoController2(UserInfoService userInfoService){
//        this.userInfoService = userInfoService;
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("/selectOne")
//    public UserInfoDO getById(
//            @RequestParam("id") Long id
//    ) {
//        UserInfoDO userInfoDO = userInfoService.getById(id);
//        UserInfoDO userInfoDO1 = UserInfoDO.builder()
//                .name("qdw2")
//                .build();
//        List<UserInfoDO>  userInfoDOS =userInfoService.getAllByCondition(userInfoDO1);
//        List<UserInfoDO>  userInfoDOS1 = userInfoService.getAllByConditionLimit(new UserInfoDO(), 0, 2);
//        List<UserInfoDO>  userInfoDOS2 = userInfoService.getAllByLimit(0,2);
//        int number = userInfoService.getTotalNumber();
//        return null;
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @PostMapping("/insert")
//    public Integer insert(
//            @RequestBody UserInfoDO userInfoDO
//    ) {
//        LocalDateTime time = LocalDateTime.now();
//        Date date = new Date();
////        UserInfoDO userInfoDO = UserInfoDO.builder()
////                .name("qdw4")
////                .age(30)
////                .createTime(date)
////                .creator("")
////                .status(0)
////                .updateTime(date)
////                .updateUser("")
////                .version(0)
////                .build();
//        int res1 = userInfoService.insert(userInfoDO);
//        return null;
//    }
//
//    @PostMapping("/insertList")
//    public Integer insertList(
//            @RequestBody List<UserInfoDO> userInfoDOList
//    ) {
//        int res1 = userInfoService.insertList(userInfoDOList);
//        return null;
//    }
//
//    @PostMapping("/delete")
//    public Integer delete(
//            @RequestBody UserInfoDO userInfoDO
//    ) {
//        boolean res1 = userInfoService.deleteById(userInfoDO.getId());
//        return null;
//    }
//
//    @PostMapping("/update")
//    public Integer update(
//            @RequestBody UserInfoDO userInfoDO
//    ) {
//        UserInfoDO res1 = userInfoService.update(userInfoDO);
//        return null;
//    }
//
//
//
//
//}