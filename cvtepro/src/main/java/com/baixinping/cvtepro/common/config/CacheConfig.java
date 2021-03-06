package com.baixinping.cvtepro.common.config;

import com.baixinping.cvtepro.common.cache.cache.Cache;
import com.baixinping.cvtepro.common.cache.cache.impl.RedisCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    @Value("${cacheClass}")
    String cacheClass;
    @Bean
    public Cache getCache() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       Cache cache = new RedisCache();
       if (cacheClass != null)
           cache = (Cache) Class.forName(cacheClass).newInstance();
       return cache;
    }
}
