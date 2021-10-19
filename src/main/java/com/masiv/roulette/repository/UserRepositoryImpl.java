package com.masiv.roulette.repository;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.masiv.roulette.model.User;
@Repository
public class UserRepositoryImpl implements UserRepository {
  private static final String KEY = "User";
  private RedisTemplate<String, User> userTemplate;
  private HashOperations hashOperations;
  public UserRepositoryImpl(RedisTemplate<String, User> userTemplate) {
    this.userTemplate = userTemplate;
  }
  @PostConstruct
  private void init() {
    hashOperations = userTemplate.opsForHash();
  }  
  @Override
  public Map<String, User> findAll() {

    return hashOperations.entries(KEY);
  }
  @Override
  public User findById(String id) {

    return (User) hashOperations.get(KEY, id);
  }
  @Override
  public void save(User user) {
    hashOperations.put(KEY, user.getUserId(), user);
  }
  @Override
  public void delete(String id) {
    hashOperations.delete(KEY, id);
  }

}
