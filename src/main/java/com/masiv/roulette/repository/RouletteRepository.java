package com.masiv.roulette.repository;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import com.masiv.roulette.model.Roulette;
public class RouletteRepository implements RedisRepository {
  private static final String KEY = "Roulette";
  private RedisTemplate<String, Roulette> redisTemplate;
  private HashOperations hashOperations;
  public RouletteRepository(RedisTemplate<String, Roulette> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }
  @PostConstruct
  private void init() {
    hashOperations = redisTemplate.opsForHash();
  }

  public RouletteRepository() {}
  @Override
  public Map<Integer, Roulette> findAll() {

    return hashOperations.entries(KEY);
  }
  @Override
  public Roulette findById(String id) {

    return (Roulette) hashOperations.get(KEY, id);
  }
  @Override
  public void save(Roulette roulette) {
    hashOperations.put(KEY, UUID.randomUUID(), roulette);
  }
  @Override
  public void delete(String id) {
    hashOperations.delete(KEY, id);
  }
}
