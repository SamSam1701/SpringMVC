package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBill implements RowMapper<bill>{

	public bill mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			bill bill = new bill();
			bill.setId(rs.getLong("id"));
			bill.setUser(rs.getString("user"));
			bill.setPhone(rs.getString("phone"));
			bill.setPassword(rs.getString("password"));
			bill.setDisplay_name(rs.getString("display_name"));
			bill.setAddress(rs.getString("address"));
			bill.setTotal(rs.getDouble("total"));
			bill.setQuanty(rs.getInt("quanty"));
			bill.setNote(rs.getString("note"));
			return bill;
		}
	}

