package com.carrom.jsandservlet;

public class Player {
	
	private String name;
	private int score;
	private int pocketedWhiteCoins;
	private int pocketedBlackCoins;
	private int pocketedRedCoins;
	
	public Player() {
		super();
	}
	
	public Player(String name, int score, int pocketedWhiteCoins, int pocketedBlackCoins, int pocketedRedCoins) {
		super();
		this.name = name;
		this.score = score;
		this.pocketedWhiteCoins = pocketedWhiteCoins;
		this.pocketedBlackCoins = pocketedBlackCoins;
		this.pocketedRedCoins = pocketedRedCoins;
	}
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getPocketedWhiteCoins() {
		return pocketedWhiteCoins;
	}
	
	public void setPocketedWhiteCoins(int pocketedWhiteCoins) {
		this.pocketedWhiteCoins = pocketedWhiteCoins;
	}
	
	public int getPocketedBlackCoins() {
		return pocketedBlackCoins;
	}
	
	public void setPocketedBlackCoins(int pocketedBlackCoins) {
		this.pocketedBlackCoins = pocketedBlackCoins;
	}
	
	public int getPocketedRedCoins() {
		return pocketedRedCoins;
	}
	
	public void setPocketedRedCoins(int pocketedRedCoins) {
		this.pocketedRedCoins = pocketedRedCoins;
	}

}
