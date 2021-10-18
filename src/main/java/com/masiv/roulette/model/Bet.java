package com.masiv.roulette.model;
public class Bet {
  private int userId;
  private byte expectedNumber;
  private char color;
  private short value;
  private int idRoulette;
  public Bet(int user, byte number, char color, short value, int idRoulette) {
    this.userId = user;
    this.expectedNumber = number;
    this.color = color;
    this.value = value;
    this.idRoulette = idRoulette;
  }
  public short getValue() {

    return value;
  }
  public void setValue(short value) {
    this.value = value;
  }
  public byte getExpectedNumber() {

    return expectedNumber;
  }
  public void setExpectedNumber(byte expectedNumber) {
    this.expectedNumber = expectedNumber;
  }
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public char getColor() {
    return color;
  }

  public void setColor(char color) {
    this.color = color;
  }

  public int getIdRoulette() {
    return idRoulette;
  }

  public void setIdRoulette(int idRoulette) {
    this.idRoulette = idRoulette;
  }
}
