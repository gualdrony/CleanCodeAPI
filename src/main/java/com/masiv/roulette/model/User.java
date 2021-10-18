package com.masiv.roulette.model;
public class User {
  private int userId;
  private double balance;
  public User(int userId) {
    balance = 0;
    this.userId = userId;
  }
  public User(int userId, double balance) {
    this.balance = balance;
    this.userId = userId;
  }
  public int getUserId() {

    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }
  public double getBalance() {

    return balance;
  }
  public void changeBalance(double balance) {
    this.balance = balance + this.balance;
  }
}
