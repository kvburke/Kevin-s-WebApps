package com.burke.stocks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StockMapper implements RowMapper<Stock> {
   public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
      Stock stock = new Stock();
      stock.setSymbol(rs.getString("Symbol"));
      stock.setPrice(rs.getInt("Price"));
      stock.setMonthpurchased(rs.getInt("Monthpurchased"));
      return stock;
   }
}