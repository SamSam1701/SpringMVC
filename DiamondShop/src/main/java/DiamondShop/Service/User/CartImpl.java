package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.CartDao;
import DiamondShop.Dto.CartDto;

@Service
public class CartImpl implements ICart{
	@Autowired
	private CartDao cartDao;

	public HashMap<Long, CartDto> Addcart(long id, HashMap<Long, CartDto> cart) {

		return cartDao.Addcart(id, cart);
	}

	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) {

		return cartDao.EditCart(id, quanty, cart);
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {

		return cartDao.DeleteCart(id, cart);
	}
	
	public double TotalPrice(HashMap<Long, CartDto> cart) {
		return cartDao.TotalPrice(cart);
	}
	
	public int TotalQuanty(HashMap<Long, CartDto> cart) {
		return cartDao.TotalQuanty(cart);
	}
	
}
