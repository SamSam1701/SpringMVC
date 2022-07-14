package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Categories;
import DiamondShop.Entity.Menu;
import DiamondShop.Entity.slides;
@Service
public interface IHome {
	@Autowired
	public List<slides> GetDataSlide();
	public List<Categories> GetDataCategories();
	public List<Menu> GetDataMenu();
	public List<ProductDto> GetDataProduct();
	public List<ProductDto> GetDataNewProduct();
}
