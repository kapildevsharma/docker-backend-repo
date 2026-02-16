package com.nagarro.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.nagarro.util.CacheNames;

@EnableCaching
@Configuration
@ConditionalOnProperty(name = "spring.redis.enabled", havingValue = "true", matchIfMissing = true)
public class RedisConfig {
	
   @Value("${cache.config.entryTtl:60}")
  private int entryTtl;

  @Value("${cache.config.users.entryTtl:30}")
  private int usersEntryTtl;
  
  @Value("${cache.config.authors.entryTtl:30}")
  private int authorsEntryTtl;
  
  @Value("${cache.config.books.entryTtl:30}")
  private int booksEntryTtl;

/**
 * Default cache configuration for Redis
 */
  @Bean
  public RedisCacheConfiguration cacheConfiguration() {
      return RedisCacheConfiguration
              .defaultCacheConfig()
              .entryTtl(Duration.ofMinutes(entryTtl))
              .disableCachingNullValues()
              .serializeValuesWith( RedisSerializationContext.SerializationPair
                              .fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }

/**
 * Customize individual caches with different TTLs
 */
  @Bean
  public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
      return builder -> {
          // Users cache
          var usersConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(usersEntryTtl)).disableCachingNullValues()
                  .serializeValuesWith(RedisSerializationContext.SerializationPair
                                  .fromSerializer(new GenericJackson2JsonRedisSerializer()));
          builder.withCacheConfiguration(CacheNames.USERS, usersConf);

          // Authors cache
          var authorsConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(authorsEntryTtl)).disableCachingNullValues()
                  .serializeValuesWith(RedisSerializationContext.SerializationPair
                                  .fromSerializer(new GenericJackson2JsonRedisSerializer()));
          builder.withCacheConfiguration(CacheNames.AUTHORS, authorsConf);

          // Books cache
          var booksConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(booksEntryTtl)).disableCachingNullValues()
                  .serializeValuesWith( RedisSerializationContext.SerializationPair
                                  .fromSerializer(new GenericJackson2JsonRedisSerializer()));
          builder.withCacheConfiguration(CacheNames.BOOKS, booksConf);
      };
  }
  
}
