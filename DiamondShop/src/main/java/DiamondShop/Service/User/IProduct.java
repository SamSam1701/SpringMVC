package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;

@Service
public interface IProduct {
	public ProductDto GetProductByID(long ID);
	
	public List<ProductDto> GetProductByIDCategory(int ID);
	
}
