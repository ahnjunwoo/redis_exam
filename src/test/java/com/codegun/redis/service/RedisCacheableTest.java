package com.codegun.redis.service;

import com.codegun.redis.service.dto.Book;
import com.codegun.redis.service.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisCacheableTest {
    @Autowired
    private RedisCacheableService redisCacheableService;
    private static final String bookRedisKey = "porter";
    private static final String bookName = "harry porter";
    private static final String userName = "jungdonghee";
    private static final String userRedisKey = "userCache::porter";

    @Test
    @DisplayName("북 레디스 저장")
    void putRedis() {
        redisCacheableService.putBook(bookRedisKey);
    }

    @Test
    @DisplayName("북 레디스 조회")
    void getRedis() {
        Book book = redisCacheableService.getBook(bookRedisKey);
        assertThat(book.getName()).isEqualTo(bookName);
    }

    @Test
    @DisplayName("유저 레디스 저장")
    void putUserRedis() {
        redisCacheableService.putUser(userRedisKey);
    }

    @Test
    @DisplayName("레디스 조회")
    void getUserRedis() {
        User user = redisCacheableService.getUser(userRedisKey);
        assertThat(user.getName()).isEqualTo(userName);
    }
}