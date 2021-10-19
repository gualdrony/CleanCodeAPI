package com.masiv.roulette.model;
import java.io.Serializable;
public class User implements Serializable{
  private static final long serialVersionUID = -1107692435748794088L;	
  private String userId;
  private double balance;
  public User(String userId) {
    balance = 0;
    this.userId = userId;
  }
  public User(String userId, double balance) {
    this.balance = balance;
    this.userId = userId;
  }
  public String getUserId() {

    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public double getBalance() {

    return balance;
  }
  public void changeBalance(double balance) {
    this.balance = balance + this.balance;
  }
}
