package com.burke.stocks;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect
public class StockOverTime {

String symbol;
int startmonth;
int endmonth;

@JsonProperty("symbol")
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
@JsonProperty("startmonth")
public int getStartmonth() {
	return startmonth;
}
public void setStartmonth(int startmonth) {
	this.startmonth = startmonth;
}
@JsonProperty("endmonth")
public int getEndmonth() {
	return endmonth;
}
public void setEndmonth(int endmonth) {
	this.endmonth = endmonth;
}






}