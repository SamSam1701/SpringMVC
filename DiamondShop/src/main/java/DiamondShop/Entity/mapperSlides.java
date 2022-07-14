package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class mapperSlides implements RowMapper<slides>{

	public slides mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		slides slides = new slides();
		
		slides.setId(rs.getInt("id"));
		slides.setImg(rs.getString("img"));
		slides.setCaption(rs.getString("caption"));
		slides.setContent(rs.getString("content"));	
		return slides;
	}
}
