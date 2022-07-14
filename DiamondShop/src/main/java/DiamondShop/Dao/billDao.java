package DiamondShop.Dao;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.BillDetail;
import DiamondShop.Entity.bill;

@Repository
public class billDao extends BaseDao{
	public int AddBill (bill bill)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bill ");
		sql.append("(");
		sql.append(" user, phone, display_name, address, total, quanty, note ");
		sql.append(" )");
		sql.append(" values (");
		sql.append(" '"+bill.getUser()+"', ");
		sql.append(" '"+bill.getPhone()+"', ");
		sql.append(" '"+bill.getDisplay_name()+"', ");
		sql.append(" '"+bill.getAddress()+"', ");
		sql.append(" '"+bill.getTotal()+"', ");
		sql.append(" '"+bill.getQuanty()+"', ");
		sql.append(" '"+bill.getNote()+"' ");
		sql.append(");");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long GetIDLastBill()
	{
		StringBuffer sql = new StringBuffer();
		sql.append("select MAX(id) from bill;");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}
	
	public int AddBillDetail(BillDetail billdetail)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into billdetail ");
		sql.append(" ( ");
		sql.append(" id_product, ");
		sql.append(" id_bill, ");
		sql.append(" quanty, ");
		sql.append(" total ");
		sql.append(") ");
		sql.append("values(");
		sql.append(" "+billdetail.getId_product()+", ");
		sql.append(" "+billdetail.getId_bill()+", ");
		sql.append(" "+billdetail.getQuanty()+", ");
		sql.append(" "+billdetail.getTotal()+" ");
		sql.append(") ");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
}
