package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.ProductDao;
import DiamondShop.Dto.ProductDto;
@Service
public class ProductImpl implements IProduct{
	
	@Autowired
	private ProductDao productDao;
	
	public ProductDto GetProductByID(long ID)
	{
		List<ProductDto> listProduct = productDao.GetProductByID(ID);
		return listProduct.get(0);
	}

	public List<ProductDto> GetProductByIDCategory(int ID) {
		return productDao.GetAllProductByID(ID);
	}
	
	
}
