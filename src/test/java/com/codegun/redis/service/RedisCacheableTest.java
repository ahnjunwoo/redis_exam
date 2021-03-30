package com.codegun.redis.service;

import com.codegun.redis.service.dto.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisCachableTest {
    @Autowired
    private RedisCacheableService redisCacheableService;
    private static final String redisKey = "porter";
    private static final String bookName = "harry porter";

    @Test
    @DisplayName("레디스 저장")
    void putRedis() {
        redisCacheableService.putBook(redisKey);
    }

    @Test
    @DisplayName("레디스 조회")
    void getRedis() {
        Book book = redisCacheableService.getBook(redisKey);
        assertThat(book.getName()).isEqualTo(bookName);
    }
}