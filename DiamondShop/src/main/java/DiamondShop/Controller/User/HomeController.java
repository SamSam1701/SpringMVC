package DiamondShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	
	@RequestMapping(value = {"/","/trang-chu/"})
	public ModelAndView Index()
	{
//		ModelAndView mv = new ModelAndView("user/index");
		_mvShare.addObject("slides",_homeservice.GetDataSlide());
		_mvShare.addObject("categories", _homeservice.GetDataCategories());
		_mvShare.addObject("products", _homeservice.GetDataProduct());
		_mvShare.addObject("newProduct", _homeservice.GetDataNewProduct());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}	
}
