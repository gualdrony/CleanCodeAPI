package com.masiv.roulette.repository;
import java.util.Map;
import com.masiv.roulette.model.User;
public interface UserRepository {
  Map<String, User> findAll();  
  User findById(String id);
  void save(User user);
  void delete(String id);
}

