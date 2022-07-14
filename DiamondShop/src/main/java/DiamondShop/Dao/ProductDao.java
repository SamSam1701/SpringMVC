package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Dto.ProductDtoMapper;

@Repository
public class ProductDao extends BaseDao{
	
	private final boolean YES = true;
	private final boolean NO = false;
	
	
	private StringBuffer SQLString()
	{
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.detail ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("from ");
		sql.append("product as p ");
		sql.append("inner join ");
		sql.append("color as c ");
		sql.append("on p.id = c.id_product ");
		return sql;
	}
	
	private String SQLProduct(boolean new_product, boolean highlight)
	{
		StringBuffer sql = SQLString();
		
		sql.append("where 1 = 1 ");
		if (highlight)
		{
			sql.append("and p.highlight = true ");
		}
		if(new_product)
		{
			sql.append("and p.new_product = true ");
		}
		sql.append("group by p.id, c.id_product ");
		sql.append("order by rand() ");
		if(highlight)
		{
			sql.append("limit 9");	
		}
		if(new_product)
		{
			sql.append("limit 12");
		}
		return sql.toString();
	}
	
	private StringBuffer SQLProductByID(int id)
	{
		StringBuffer sql = SQLString();
		
		sql.append("where 1 = 1 ");
		sql.append("and p.id_category = "+id+" ");
		return sql;
	}
	
	private String SQLProductPaginate(int id, int start, int totalProductPage)
	{
		StringBuffer sql = SQLProductByID(id);
		sql.append("limit "+start+", "+totalProductPage+" ");
		return sql.toString();
	}
	
	private String SqlProductByID(long id)
	{
		StringBuffer sql = SQLString();
		sql.append("where 1 = 1 ");
		sql.append("and p.id = "+id+" ");
		sql.append("limit 1 ");
		return sql.toString();
	}
	
	public List<ProductDto> GetDataProduct()
	{
		String sql = SQLProduct(NO, YES);
		List<ProductDto> list  = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}
	
	public List<ProductDto> GetDataNewProduct()
	{
		String sql = SQLProduct(YES, NO);
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}
	
	public List<ProductDto> GetAllProductByID(int id)
	{
		String sql = SQLProductByID(id).toString();
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}
	
	
	public List<ProductDto> GetDataProductPaginate(int id,int start, int totalProductPage)
	{
		StringBuffer sqlGetDataByID = SQLProductByID(id);
		List<ProductDto> listProductByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductDtoMapper());
		List<ProductDto> list = new ArrayList<ProductDto>();
		if(listProductByID.size()>0) // nếu không có dòng này, thì câu sql sẽ bị lỗi syntax, khi đó cần bỏ vào đk để xét trước khi tạo câu sql
		{
			String sql = SQLProductPaginate(id, start, totalProductPage);
			list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		}
		return list;
	}
	
	public List<ProductDto> GetProductByID(long id)
	{
		String sql = SqlProductByID(id);
		List<ProductDto> ProductByID = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return ProductByID;
	}
	
	public ProductDto FindProductByID(long id)
	{
		String sql = SqlProductByID(id);
		ProductDto ProductByID = _jdbcTemplate.queryForObject(sql, new ProductDtoMapper());
		return ProductByID;
	}
}
