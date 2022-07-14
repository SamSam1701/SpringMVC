package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.ProductDao;
import DiamondShop.Dto.ProductDto;

@Service
public class CategoryImpl implements ICategory{

	@Autowired
	private ProductDao productDao;
	
	public List<ProductDto> GetAllProductByID(int ID) {		
		return productDao.GetAllProductByID(ID);
	}
	
	public List<ProductDto> GetDataProductPaginate(int id ,int start, int totalProductPage) {
		List<ProductDto> product = productDao.GetDataProductPaginate(id, start, totalProductPage);
		return product;
	}


}
