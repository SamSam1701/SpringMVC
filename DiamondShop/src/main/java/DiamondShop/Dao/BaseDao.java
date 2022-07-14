package DiamondShop.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
//	public List<Menu> GetDataMenu()
//	{
//		List<Menu> list = new ArrayList<Menu>();
//		String sql = "select * from menu";
//		list = _jdbcTemplate.query(sql, new MapperMenu());
//		return list;
//	} 
}
