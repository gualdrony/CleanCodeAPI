package com.masiv.roulette.repository;
import java.util.Map;
import com.masiv.roulette.model.Roulette;
public interface RedisRepository {
  Map<String, Roulette> findAll();  
  Roulette findById(String id);
  void save(Roulette roulette);
  void delete(String id);
}
