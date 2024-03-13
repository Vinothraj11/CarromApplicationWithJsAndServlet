package com.carrom.jsandservlet;

public class Board {
	
	private int whiteCoins;
	private int blackCoins;
	private int redCoins;
	private int striker;
	private boolean isRedCoinPocketed;
	
	public Board() {
		super();
	}

	public Board(int whiteCoins, int blackCoins, int redCoins, int striker, boolean isRedCoinPocketed) {
		super();
		this.whiteCoins = whiteCoins;
		this.blackCoins = blackCoins;
		this.redCoins = redCoins;
		this.striker = striker;
		this.isRedCoinPocketed = isRedCoinPocketed;
	}

	public int getWhiteCoins() {
		return whiteCoins;
	}
	
	public void setWhiteCoins(int whiteCoins) {
		this.whiteCoins = whiteCoins;
	}
	
	public int getBlackCoins() {
		return blackCoins;
	}
	
	public void setBlackCoins(int blackCoins) {
		this.blackCoins = blackCoins;
	}
	
	public int getRedCoins() {
		return redCoins;
	}
	
	public void setRedCoins(int redCoins) {
		this.redCoins = redCoins;
	}

	public int getStriker() {
		return striker;
	}

	public void setStriker(int striker) {
		this.striker = striker;
	}

	public boolean isRedCoinPocketed() {
		return isRedCoinPocketed;
	}

	public void setRedCoinPocketed(boolean isRedCoinPocketed) {
		this.isRedCoinPocketed = isRedCoinPocketed;
	}

}
