package com.masiv.roulette.service;
import java.util.List;
import com.masiv.roulette.model.Bet;
public interface TestService {
  int createRoulette();
  void openRoulette(int idRoulette);
  void makeBet(Bet bet);
  byte closeBet(int idRoulette);
  List<String> createdRoulettes();
}
