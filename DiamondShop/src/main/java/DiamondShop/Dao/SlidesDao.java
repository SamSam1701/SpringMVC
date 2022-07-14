package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DiamondShop.Entity.mapperSlides;
import DiamondShop.Entity.slides;

@Repository
public class SlidesDao extends BaseDao{
	
	public List<slides> getDataSlide()
	{
		List<slides> list = new ArrayList<slides>();
		String sql = "select * from slides";
		list = _jdbcTemplate.query(sql, new mapperSlides());
		return list;
	} 
}
