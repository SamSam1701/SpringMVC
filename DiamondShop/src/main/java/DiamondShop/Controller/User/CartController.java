package DiamondShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Users;
import DiamondShop.Entity.bill;
import DiamondShop.Service.User.CartImpl;
import DiamondShop.Service.User.billImpl;

@Controller
public class CartController extends BaseController{

	@Autowired
	private CartImpl cartSer = new CartImpl();
	
	@Autowired
	private billImpl billSer = new billImpl();
	
	@RequestMapping(value="gio-hang")
	public ModelAndView Index()
	{
		_mvShare.addObject("slides",_homeservice.GetDataSlide());
		_mvShare.addObject("categories", _homeservice.GetDataCategories());
		_mvShare.addObject("products", _homeservice.GetDataProduct());
		_mvShare.addObject("newProduct", _homeservice.GetDataNewProduct());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value="AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id)
	{
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDto> cart = (HashMap<Long,CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartSer.Addcart(id, cart);
		
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartSer.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartSer.TotalPrice(cart)); 
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id, @PathVariable int quanty)
	{
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDto> cart = (HashMap<Long,CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartSer.EditCart(id,quanty, cart);
		
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartSer.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartSer.TotalPrice(cart)); 
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id)
	{
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDto> cart = (HashMap<Long,CartDto>)session.getAttribute("Cart");
		if(cart == null)
		{
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartSer.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartSer.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartSer.TotalPrice(cart)); 
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="checkout", method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session)
	{
		_mvShare.setViewName("user/bill/checkout");
		bill bill = new bill();
		Users LoginInfo = (Users)session.getAttribute("LoginInfo");
		if(LoginInfo!=null)
		{
			bill.setAddress(LoginInfo.getAddress());
			bill.setDisplay_name(LoginInfo.getDisplay_name());
			bill.setUser(LoginInfo.getUser());
		}
		_mvShare.addObject("bill", bill);
		return _mvShare;
	}
	
	@RequestMapping(value="checkout", method = RequestMethod.POST)
	public String CheckoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") bill bill)
	{
		//bill.setQuanty(Integer.parseInt((String) session.getAttribute("TotalPriceCart")));
		bill.setTotal(Double.parseDouble(session.getAttribute("TotalQuantyCart").toString()));
		if(billSer.AddBill(bill) > 0)
		{
			@SuppressWarnings("unchecked")
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billSer.AddBillDetail(cart);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
}
