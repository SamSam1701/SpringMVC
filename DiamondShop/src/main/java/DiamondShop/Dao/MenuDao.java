package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperMenu;
import DiamondShop.Entity.Menu;
@Repository
public class MenuDao extends BaseDao{

	public List<Menu> GetDataMenu()
	{
		List<Menu> list = new ArrayList<Menu>();
		String sql = "select * from menu";
		list = _jdbcTemplate.query(sql, new MapperMenu());
		return list;
	} 
}
