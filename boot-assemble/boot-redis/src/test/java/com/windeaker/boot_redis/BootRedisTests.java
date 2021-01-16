package com.windeaker.boot_redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.boot.RedisUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BootRedisTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test(){
//        System.out.println(redisUtil.dumpKey("delKey2"));
        System.out.println(redisUtil.keyPattern("get*"));
    }
}
