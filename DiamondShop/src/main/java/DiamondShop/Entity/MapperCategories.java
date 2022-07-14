package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategories implements RowMapper<Categories>{

	public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Categories cate = new Categories();
		
		cate.setId(rs.getInt("id"));
		cate.setName(rs.getString("name"));
		cate.setDescription(rs.getString("description"));
		return cate;
	}
}
