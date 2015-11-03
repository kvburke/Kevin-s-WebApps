package com.burke.stocks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PercentagesMapper implements RowMapper<Percentages> {
   public Percentages mapRow(ResultSet rs, int rowNum) throws SQLException {
      Percentages percentages = new Percentages();
      percentages.setSymbol(rs.getString("symbol"));
      percentages.setCount(rs.getInt("sum(Price)"));
   
      return percentages;
   }
}