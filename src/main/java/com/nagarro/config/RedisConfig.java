package com.nagarro.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.nagarro.util.CacheNames;

@EnableCaching
@Configuration
public class RedisConfig {
	
   @Value("${cache.config.entryTtl:60}")
  private int entryTtl;

  @Value("${cache.config.users.entryTtl:30}")
  private int usersEntryTtl;
  
  @Value("${cache.config.authors.entryTtl:30}")
  private int authorsEntryTtl;
  
  @Value("${cache.config.books.entryTtl:30}")
  private int booksEntryTtl;
  
  @Bean
  public RedisCacheConfiguration cacheConfiguration() {
      return RedisCacheConfiguration
              .defaultCacheConfig()
              .entryTtl(Duration.ofMinutes(entryTtl))
              .disableCachingNullValues()
              .serializeValuesWith( RedisSerializationContext.SerializationPair
                              .fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }

  @Bean
  public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
      return builder -> {
          var usersConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(usersEntryTtl));
          builder.withCacheConfiguration(CacheNames.USERS, usersConf);
          var authorsConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(authorsEntryTtl));
          builder.withCacheConfiguration(CacheNames.AUTHORS, authorsConf);
          var booksConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(booksEntryTtl));
          builder.withCacheConfiguration(CacheNames.BOOKS, booksConf);
      };
  }
  
}
