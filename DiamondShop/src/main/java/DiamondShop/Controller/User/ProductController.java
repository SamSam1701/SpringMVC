package DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Service.User.ProductImpl;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	ProductImpl product;
	
	@RequestMapping(value = {"chi-tiet-san-pham/{id}"})
	public ModelAndView Index(@PathVariable long id)
	{
		_mvShare.addObject("product",product.GetProductByID(id));
		_mvShare.addObject("categories", _homeservice.GetDataCategories());
		_mvShare.addObject("productByIDCategory", product.GetProductByIDCategory(product.GetProductByID(id).getId_category()));
		
		_mvShare.setViewName("user/product/product");
		return _mvShare;
	}
}
