package com.masiv.roulette.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.masiv.roulette.model.Bet;
public interface Services {
  String createRoulette();
  void openRoulette(String idRoulette);
  void makeBet(Bet bet);
  Map<String,List<Bet>> closeBet(String idRoulette);
  List<String> createdRoulettes();
}
