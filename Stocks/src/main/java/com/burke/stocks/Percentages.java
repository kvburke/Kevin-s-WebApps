package com.burke.stocks;

public class Percentages {

	Percentages(){
		
	}
	
	Percentages(String symbol, int count){
		this.symbol=symbol;
		this.count=count;
	}
	
	private String symbol;
	private int count;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}