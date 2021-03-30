package com.codegun.redis.service;

import com.codegun.redis.service.dto.Book;
import com.codegun.redis.service.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheableService {

    @Cacheable(cacheNames = "bookCache", key = "#name")
    public Book getBook(String name) {
        if (name.equals("porter")) {
            return new Book("harry porter");
        }else{
            return new Book("etc");
        }
    }

    @CacheEvict(cacheNames = "bookCache", key = "#name")
    public void putBook(String name) {
        log.info("book cacheEvict!! : {}",name);
    }

    @Cacheable(cacheNames = "userCache", key = "#name")
    public User getUser(String name) {
        if (name.equals("junwoo")) {
            return User.builder()
                    .name("ahnjunwoo")
                    .age(36)
                    .build();
        }else{
            return User.builder()
                    .name("jungdonghee")
                    .age(24)
                    .build();
        }
    }

    @CacheEvict(cacheNames = "userCache", key = "#name")
    public void putUser(String name) {
        log.info("user cacheEvict!! : {}",name);
    }
}
