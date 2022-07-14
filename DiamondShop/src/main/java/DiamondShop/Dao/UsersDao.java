package DiamondShop.Dao;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperUsers;
import DiamondShop.Entity.Users;

@Repository
public class UsersDao extends BaseDao{
	
	public int AddAccount(Users user)
	{
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert ");
		sql.append("into users( ");
		sql.append("id, ");
		sql.append("user, ");
		sql.append("password, ");
		sql.append("display_name, ");
		sql.append("address) ");
		sql.append("values ");
		sql.append("(null, ");
		sql.append(" '"+user.getUser()+"', ");
		sql.append(" '"+user.getPassword()+"', ");
		sql.append(" '"+user.getDisplay_name()+"', ");
		sql.append(" '"+user.getAddress()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Users GetUserByAccount(Users user)
	{
		
		String sql = "Select * from users where user = '"+user.getUser()+"'";
		
		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
	
		return result;
	}
	
	
}
