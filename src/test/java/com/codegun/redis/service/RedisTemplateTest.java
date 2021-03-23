package com.codegun.redis.service;

import com.codegun.redis.service.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisTemplateTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String redisKey = "codegun";
    private static final String name = "안준우";
    private static final int age = 36;

    @Test
    @DisplayName("레디스 저장")
    void putRedis() {
        redisTemplate.opsForValue().set(redisKey, User.builder()
                .name(name)
                .age(age)
                .build().toString());
    }

    @Test
    @DisplayName("레디스 조회")
    void getRedis() {
        User user = (User) redisTemplate.opsForValue().get(redisKey);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getAge()).isEqualTo(age);
    }
}