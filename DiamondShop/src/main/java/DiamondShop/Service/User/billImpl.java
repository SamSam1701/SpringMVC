package DiamondShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.billDao;
import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.BillDetail;
import DiamondShop.Entity.bill;

@Service
public class billImpl implements IBill{

	@Autowired
	private billDao billdao;
	
	public int AddBill(bill bill) {
		return billdao.AddBill(bill);
	}

	public void AddBillDetail(HashMap<Long, CartDto> cart) {
		long idBill = billdao.GetIDLastBill();
		
		for(Map.Entry<Long, CartDto> itemCart:cart.entrySet()){
			BillDetail billdetail = new BillDetail();
			billdetail.setId_bill(idBill);
			billdetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billdetail.setQuanty(itemCart.getValue().getQuanty());
			billdetail.setTotal(itemCart.getValue().getTotalPrice());
			billdao.AddBillDetail(billdetail);
		}
	}
	
}
