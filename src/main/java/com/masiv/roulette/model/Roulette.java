package com.masiv.roulette.model;
import java.util.ArrayList;
public class Roulette {
  private int id;
  private boolean open;
  private byte winnerNumber;
  private ArrayList<Bet> bets;
  public Roulette(int id) {
    this.id = id;
    this.open = false;
    bets = new ArrayList<Bet>();
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
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
