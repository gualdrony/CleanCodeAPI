package com.masiv.roulette.repository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.masiv.roulette.model.Roulette;
@Repository
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
  @Override
  public Map<String, Roulette> findAll() {

    return hashOperations.entries(KEY);
  }
  @Override
  public Roulette findById(String id) {

    return (Roulette) hashOperations.get(KEY, id);
  }
  @Override
  public void save(Roulette roulette) {
	Roulette lr_roulette;
	lr_roulette = roulette;
	if(lr_roulette!=null) {
		String idRoulette;
		idRoulette = lr_roulette.getId();
		if(idRoulette!=null) {
			hashOperations.put(KEY, idRoulette, lr_roulette);		
		}
	}
  }
  @Override
  public void delete(String id) {
    hashOperations.delete(KEY, id);
  }
  public int countRoulettes() {
    HashMap<String, Roulette>  roulettes;
    int numberRoulettes= 0;
    roulettes = new HashMap<String,Roulette>(hashOperations.entries(KEY));
    if(roulettes != null) {
    	numberRoulettes = roulettes.size();
    }
    
    return numberRoulettes;
  }
}
