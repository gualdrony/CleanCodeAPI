package com.masiv.roulette.model;
import java.io.Serializable;
import java.util.ArrayList;
public class Roulette implements Serializable{
  private static final long serialVersionUID = -803883647256237794L;
  private String id;
  private boolean open;
  private byte winnerNumber;
  private ArrayList<Bet> bets;
  public Roulette(String id) {
    this.id = id;
    this.open = false;
    bets = new ArrayList<Bet>();
  }
  public ArrayList<Bet> getBets(){
	  
	return this.bets;
  }
  public String getId() {
	  
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void open() {
    this.open = true;
  }
  public boolean isOpen() {
    return open;
  }
  public byte close() {
    winnerNumber = (byte) Math.floor(Math.random() * 37);
    this.open = false;

    return winnerNumber;
  }
  public void addBet(Bet bet) {
    bets.add(bet);
  }
  public ArrayList<Bet> winnerBets() {
    char winnerColor = (winnerNumber % 2 == 0) ? 'R' : 'B';
    ArrayList<Bet> winnerBets = new ArrayList<Bet>();
    for (Bet bet : this.bets) {
      if (bet.getExpectedNumber() == winnerNumber || bet.getColor() == winnerColor) {
        winnerBets.add(bet);
      }
    }

    return winnerBets;
  }
}
