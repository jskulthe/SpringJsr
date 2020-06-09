package com.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

public class MultipleCacheResolver implements CacheResolver {

    private final CacheManager simpleCacheManager;

    private final CacheManager caffeineCacheManager;

    @Value("${cache.name}")
    private String cacheName;
    
    public MultipleCacheResolver(CacheManager simpleCacheManager, CacheManager caffeineCacheManager) {
        this.simpleCacheManager = simpleCacheManager;
        this.caffeineCacheManager = caffeineCacheManager;

    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        Collection<Cache> caches = new ArrayList<Cache>();
        
        System.out.println("cacheName "+cacheName);
        
        if ((cacheName).equalsIgnoreCase("caffeineCache")) {
            caches.add(caffeineCacheManager.getCache("caffeineCache"));
        } else {
            caches.add(simpleCacheManager.getCache("concurrentCache"));
        }
        return caches;
    }
}