package com.burke.stocks;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class StockOverTimeMapper implements RowMapper<StockOverTime> {
	public StockOverTime mapRow(ResultSet rs, int rowNum) throws SQLException {
		StockOverTime stockovertime = new StockOverTime();
		stockovertime.setSymbol(rs.getString("symbol"));
		stockovertime.setStartmonth(rs.getInt("startmonth"));
		stockovertime.setEndmonth(rs.getInt("endmonth"));
		return stockovertime;
		   }
		   
	
}