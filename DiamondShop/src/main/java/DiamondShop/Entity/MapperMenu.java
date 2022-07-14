package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMenu implements RowMapper<Menu>{

	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Menu mn = new Menu();
		
		mn.setId(rs.getInt("id"));
		mn.setName(rs.getString("name"));
		mn.setUrl(rs.getString("url"));
		return mn;
	}
}