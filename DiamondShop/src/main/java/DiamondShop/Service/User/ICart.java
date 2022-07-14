package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.CartDto;

@Service
public interface ICart {
	public  HashMap<Long, CartDto> Addcart(long id, HashMap<Long, CartDto> cart);
	public  HashMap<Long, CartDto> EditCart(long id,int quanty, HashMap<Long, CartDto> cart);
	public  HashMap<Long, CartDto> DeleteCart(long id,HashMap<Long, CartDto> cart);
	public int TotalQuanty(HashMap<Long, CartDto> cart);
	public double TotalPrice(HashMap<Long, CartDto> cart);
}
