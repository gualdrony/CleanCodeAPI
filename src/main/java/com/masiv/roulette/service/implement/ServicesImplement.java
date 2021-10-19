package com.masiv.roulette.service.implement;
import java.util.List;
import java.util.Map;

import javax.imageio.event.IIOReadUpdateListener;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masiv.roulette.model.Bet;
import com.masiv.roulette.model.Roulette;
import com.masiv.roulette.model.User;
import com.masiv.roulette.repository.RouletteRepository;
import com.masiv.roulette.repository.UserRepositoryImpl;
import com.masiv.roulette.service.Services;
@Service
public class ServicesImplement implements Services {
  @Autowired
  private RouletteRepository rouletteRepository;
  @Autowired
  private UserRepositoryImpl userRepository;
  @Override
  public String createRoulette() {
	int numberRoulette;
	String idRoulette;
	Roulette roulette;
	numberRoulette = 10000+rouletteRepository.countRoulettes()+1;
    idRoulette = String.valueOf(numberRoulette);
    roulette = new Roulette(idRoulette);
    rouletteRepository.save(roulette);
    return idRoulette;
  }
  @Override
  public void openRoulette(String idRoulette) {
	  Roulette roulette;
	  roulette = rouletteRepository.findById(idRoulette);
	  roulette.open();
	  rouletteRepository.save(roulette);
  }
  @Override
  public void makeBet(Bet bet) {

    Roulette roulette = rouletteRepository.findById(bet.getIdRoulette());
    if ((roulette != null) && roulette.isOpen()) {
      roulette.addBet(bet);
      User user = userRepository.findById(bet.getUserId());
      if (user==null) {
    	userRepository.save(new User(bet.getUserId()));
      }
      rouletteRepository.save(roulette);
    }
  }
  @Override
  public Map<String,List<Bet>> closeBet(String idRoulette) {
    HashMap<String,List<Bet>> results= new HashMap<String,List<Bet>>();
	byte winnerNumber;
    winnerNumber = -1;
    Roulette roulette = rouletteRepository.findById(idRoulette);
    if (roulette != null) {
      results.put("Total Bets", roulette.getBets());
      winnerNumber = roulette.close();
      ArrayList<Bet> winnerBets = roulette.winnerBets();
      results.put("Winners", winnerBets);
      if (winnerBets != null && !winnerBets.isEmpty()) {
        for (Bet bet : winnerBets) {
          User user = userRepository.findById(bet.getUserId());
          if (user != null) {
            if (bet.getExpectedNumber() == winnerNumber) {
              user.changeBalance(bet.getValue() * 5);
            } else {
              user.changeBalance(bet.getValue() * 1.8);
            }
          }
        }
      }
      rouletteRepository.save(roulette);
    }

    return results;
  }
  @Override
  public List<String> createdRoulettes() {
    List<String> rouletteList = new ArrayList<String>();
    for (HashMap.Entry<String, Roulette> roulette : rouletteRepository.findAll().entrySet()) {
      rouletteList.add(roulette.getKey() + ":" + roulette.getValue().isOpen());
    }

    return rouletteList;
  }
}
