package com.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Primary;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class MultipleCacheManagerConfig extends CachingConfigurerSupport {

	// Caffeine Cache
    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("caffeineCache");
        cacheManager.setCaffeine(Caffeine.newBuilder()
            .initialCapacity(200)
            .maximumSize(500)
            .weakKeys()
            .recordStats());
        return cacheManager;
    }

    // ConcurrentMapCache
    @Bean
    public CacheManager alternateCacheManager() {
        return new ConcurrentMapCacheManager("concurrentCache");
    }

    @Bean
    public CacheResolver cacheResolver() {
        return new MultipleCacheResolver(alternateCacheManager(), cacheManager());
    }
}