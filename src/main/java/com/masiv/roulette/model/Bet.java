package com.masiv.roulette.model;
import java.io.Serializable;
public class Bet implements Serializable{
  private static final long serialVersionUID = 7975507322842948714L;
  private String userId;
  private byte expectedNumber;
  private char color;
  private short value;
  private String idRoulette;
  public Bet(String user, byte number, char color, short value, String idRoulette) {
    userId = user;
    expectedNumber = number;
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
  public String getUserId() {
   
	return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public char getColor() {
    
	return color;
  }
  public void setColor(char color) {
    this.color = color;
  }
  public String getIdRoulette() {
    
	return idRoulette;
  }
  public void setIdRoulette(String idRoulette) {
    this.idRoulette = idRoulette;
  }
}
