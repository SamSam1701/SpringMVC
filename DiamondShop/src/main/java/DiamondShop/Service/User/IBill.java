package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.bill;

@Service
public interface IBill {
	public int AddBill(bill bill);
	
	public void AddBillDetail(HashMap<Long, CartDto> cart);
}
