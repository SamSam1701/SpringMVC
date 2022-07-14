package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.CategoriesDao;
import DiamondShop.Dao.MenuDao;
import DiamondShop.Dao.ProductDao;
import DiamondShop.Dao.SlidesDao;
import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Categories;
import DiamondShop.Entity.Menu;
import DiamondShop.Entity.slides;
@Service
public class HomeImpl implements IHome{
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategoriesDao cateDao;	
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductDao productDao;
	
	public List<slides> GetDataSlide() {
		return slidesDao.getDataSlide();
	}

	public List<Categories> GetDataCategories() {
		return cateDao.getDataCategories();
	}
	
	public List<Menu> GetDataMenu(){
		return menuDao.GetDataMenu();
	}
	
	public List<ProductDto> GetDataProduct(){
		List<ProductDto> list = productDao.GetDataProduct();
		return list;
	}
	
	public List<ProductDto> GetDataNewProduct(){
		List<ProductDto> list = productDao.GetDataNewProduct();
		return list;
	}
}
