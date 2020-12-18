package com.example.service.impl;

import com.example.component.ServiceResult;
import com.example.entity.dto.UserInfoListDTO;
import com.example.service.UserInfoService;
import com.example.utils.TestApplication;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class UserInfoServiceImplTest extends TestApplication {

    private UserInfoService userInfoService;

    public static void main(String[] args){
        User user1 = User.builder()
                .age(1)
                .name("qq")
                .build();
        User user2 = User.builder()
                .age(2)
                .name("qw")
                .build();
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        list.forEach(item->item.setName("tt"));
    }

    @Autowired
    public UserInfoServiceImplTest(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Test
    void getById() {
        User user1 = User.builder()
                .age(1)
                .name("qq")
                .build();
        User user2 = User.builder()
                .age(2)
                .name("qw")
                .build();
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        list.forEach(item->item.setName("tt"));

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        numbers.forEach(i-> System.out.println(i));
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> {
            System.out.println(i);
            return i;
        }).collect(Collectors.toList());
        ServiceResult<UserInfoListDTO> serviceResult = userInfoService.getAllByPage(1,10);
    }

    @Test
    void getAllByPage() {
    }

    @Data
    @Builder
    static class User{
        private String name;
        private int age;
    }
}