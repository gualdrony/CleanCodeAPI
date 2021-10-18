package com.masiv.roulette.service.implement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import com.masiv.roulette.model.Bet;
import com.masiv.roulette.model.Roulette;
import com.masiv.roulette.model.User;
import com.masiv.roulette.service.TestService;
@Service
public class TestServiceImplement implements TestService {
  private static int idRoulette;
  private static int idUser;
  private HashMap<Integer, Roulette> roulettes;
  private HashMap<Integer, User> users;
  public TestServiceImplement() {
    idRoulette = 1;
    idUser = 1;
    roulettes = new HashMap<Integer, Roulette>();
    users = new HashMap<Integer, User>();
  }
  @Override
  public int createRoulette() {
    roulettes.put(idRoulette, new Roulette(idRoulette));

    return idRoulette++;
  }
  @Override
  public void openRoulette(int idRoulette) {
    roulettes.get(idRoulette).open();
  }
  @Override
  public void makeBet(Bet bet) {
    if ((roulettes != null) && !roulettes.isEmpty()) {
      Roulette roulette = roulettes.get(bet.getIdRoulette());
      if ((roulette != null) && roulette.isOpen()) {
        roulette.addBet(bet);
        if ((users != null) && !users.isEmpty()) {
          if (!users.containsKey(bet.getUserId())) {
            users.put(idUser, new User(idUser));
          }
        }
      }
    }
  }
  @Override
  public byte closeBet(int idRoulette) {
    byte winnerNumber;
    winnerNumber = -1;
    if ((roulettes != null) && !roulettes.isEmpty()) {
      Roulette roulette = roulettes.get(idRoulette);
      if (roulette != null) {
        winnerNumber = roulette.close();
        for (Bet bet : roulette.winnerBets()) {
          if ((users != null) && !users.isEmpty()) {
            User user = users.get(bet.getUserId());
            if (user != null) {
              if (bet.getExpectedNumber() == winnerNumber) {
                user.changeBalance(bet.getValue() * 5);
              } else {
                user.changeBalance(bet.getValue() * 1.8);
              }
            }
          }
        }
      }
    }

    return winnerNumber;
  }
  @Override
  public List<String> createdRoulettes() {
    List<String> rouletteList = new ArrayList<String>();
    for (HashMap.Entry<Integer, Roulette> roulette : roulettes.entrySet()) {
      rouletteList.add(roulette.getKey() + ":" + roulette.getValue().isOpen());
    }

    return rouletteList;
  }
}
