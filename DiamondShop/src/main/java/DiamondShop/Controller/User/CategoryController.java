package DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginateDto;
import DiamondShop.Service.User.CategoryImpl;
import DiamondShop.Service.User.PaginateImpl;

@Controller
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryImpl categoryService;
	
	@Autowired
	private PaginateImpl paginate;
	
	private int totalProductPage = 9;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id)
	{
		_mvShare.setViewName("user/product/category");
		int totalData = categoryService.GetAllProductByID(Integer.parseInt(id)).size();
		PaginateDto paginateInfo = paginate.getInfoPaginate(totalData, totalProductPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductPaginate", categoryService.GetDataProductPaginate(Integer.parseInt(id),paginateInfo.getStart(), totalProductPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage)
	{
		_mvShare.setViewName("user/product/category");
		int totalData = categoryService.GetAllProductByID(Integer.parseInt(id)).size();
		PaginateDto paginateInfo = paginate.getInfoPaginate(totalData, totalProductPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductPaginate", categoryService.GetDataProductPaginate(Integer.parseInt(id),paginateInfo.getStart(), totalProductPage));
		return _mvShare;
	}
}
