package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;

@Service
public interface ICategory {
	public List<ProductDto> GetAllProductByID(int ID);
	public List<ProductDto> GetDataProductPaginate(int id,int start, int end);
	
}
