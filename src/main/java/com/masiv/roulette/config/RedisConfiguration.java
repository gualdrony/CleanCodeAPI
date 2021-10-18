package com.masiv.roulette.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.masiv.roulette.model.Roulette;
@Configuration
public class RedisConfiguration {
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {

    return new JedisConnectionFactory();
  }
  @Bean
  public RedisTemplate<String, Roulette> redisTemplate() {
    final RedisTemplate<String, Roulette> redisTemplate;
    redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());

    return redisTemplate;
  }
}