//package com.huseyingurel.configuration;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//
//import java.time.Duration;
//
//@Configuration
//@ConditionalOnProperty(value="resolved.cache.enabled", havingValue = "true", matchIfMissing = true)
//@Slf4j
//public class CacheConfiguration extends CachingConfigurerSupport {
//
//    @Value("${redis.host}")
//    private String redisHost;
//
//    @Value("${redis.port}")
//    private Integer redisPort;
//
//    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> builder
//                .withCacheConfiguration("itemCache",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(2)))
//                .withCacheConfiguration("customerCache",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(2)));
//    }
//
//    @Bean
//    public RedisCacheConfiguration testcacheConfiguration() {
//        return RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(2))
//                .disableCachingNullValues()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//    }
//    @Bean
//    public LettuceConnectionFactory lettuceConnectionFactory() {
//
//        log.info("Info -> Lettuce Connection Factory");
//
//        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
//        lettuceConnectionFactory.setHostName(this.redisHost);
//        lettuceConnectionFactory.setPort(this.redisPort);
//
//        log.info("RedisHost  -> " + lettuceConnectionFactory.getHostName());
//        log.info("RedisPort  -> " + lettuceConnectionFactory.getPort());
//        log.info("ExpireTime -> " + 1);
//
//        return lettuceConnectionFactory;
//    }
//
//
//    @Bean
//    public RedisTemplate redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
//
//        log.info("Info -> Redis Template");
//
//        RedisTemplate redisTemplate = new RedisTemplate();
//
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//
//        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
//        return redisTemplate;
//    }
//
//
//
//    @Bean
//    public RedisCacheConfiguration rediscacheConfiguration() {
//
//        log.info("Info -> Redis Cache Configuration");
//
//        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(2))
//                .disableCachingNullValues()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//        cacheConfig.usePrefix();
//
//        log.info("Duration -> " + cacheConfig.getTtl().getSeconds());
//
//        return cacheConfig;
//    }
//
//
//    @Bean
//    public RedisCacheManager cacheManager() {
//
//        log.info("Info -> Redis Cache Manager");
//        CacheConfiguration cacheConfig=new CacheConfiguration();
//
//        RedisCacheManager rcm = RedisCacheManager
//                .builder(this.lettuceConnectionFactory())
//                .cacheDefaults(this.rediscacheConfiguration())
//                .build();
//
//        return rcm;
//    }
//    @Autowired
//    private CacheManager cacheManager;
//
//    @EventListener
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        cacheManager.getCacheNames()
//                .parallelStream()
//                .forEach(n -> cacheManager.getCache(n).clear());
//    }
//}
//
