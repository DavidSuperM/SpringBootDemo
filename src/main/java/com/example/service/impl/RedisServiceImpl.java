package com.example.service.impl;

import com.example.component.ServiceResult;
import com.example.entity.UserInfoDO;
import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * @author david
 */
@Service
public class RedisServiceImpl implements RedisService {

    private StringRedisTemplate stringRedisTemplate;
    private RedisTemplate redisTemplate;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }

    public static void main(String[] args){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
        localDateTime = localDateTime.withHour(23).withMinute(59).withSecond(59);

        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        LocalDate localDate = LocalDate.now();
        localDateTime.minusDays(1);
        localDateTime.plusDays(1);
        String res = localDateTime.toString();

        //时间转字符串格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
//字符串转时间
        String dateTimeStr = "2018-07-28 14:11:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime2 = LocalDateTime.parse(dateTimeStr, df);

        LocalDateTime dateTime1 = LocalDateTime.parse("2020-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("");

    }


    @Override
    public ServiceResult<UserInfoDO> getNameById(Long id) {
        stringRedisTemplate.opsForValue().set("1","qdw1");
        String res1 = stringRedisTemplate.opsForValue().get("1");
        redisTemplate.opsForValue().set("1.2", "2.2");
        String res2 = (String)redisTemplate.opsForValue().get("1");
        String res3 = (String)redisTemplate.opsForValue().get("1.2");

        redisTemplate.opsForZSet().add("2","z1", 10);
        redisTemplate.opsForZSet().add("2","z2", 11);
        Set<String> set = (Set<String>) redisTemplate.opsForZSet().range("2",0,1);

        UserInfoDO infoDO = UserInfoDO.builder()
                .age(18)
                .name("eee")
                .build();
        redisTemplate.opsForValue().set("3",infoDO);
        UserInfoDO userInfoDO = (UserInfoDO) redisTemplate.opsForValue().get("3");
        return ServiceResult.createSuccessResult();
    }
}
