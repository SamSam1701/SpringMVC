package DiamondShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductDtoMapper implements RowMapper<ProductDto>{

	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto product = new ProductDto();
		product.setId_product(rs.getLong("id_product"));
		product.setId_category(rs.getInt("id_category"));
		product.setSizes(rs.getString("sizes"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setSale(rs.getInt("sale"));
		product.setTitle(rs.getString("title"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNew_product(rs.getBoolean("new_product"));
		product.setDetail(rs.getString("detail"));
		product.setId_color(rs.getLong("id_color"));
		product.setName_color(rs.getString("name_color"));
		product.setCode_color(rs.getString("code_color"));
		product.setImg(rs.getString("img"));
		product.setCreated_at(rs.getDate("created_at"));
		product.setUpdated_at(rs.getDate("updated_at"));
		return product;
	}
	
}
