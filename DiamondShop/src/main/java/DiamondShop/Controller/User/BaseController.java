package DiamondShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Service.User.HomeImpl;

@Controller
public class BaseController {
	@Autowired
	HomeImpl _homeservice;
	
	public ModelAndView _mvShare = new ModelAndView();
	
	//Giup vua vo chay ngay init() voi thu vien javax annotation
	@PostConstruct 
	public ModelAndView Init()
	{
		_mvShare.addObject("menu",_homeservice.GetDataMenu());
		return _mvShare;
	}
}
