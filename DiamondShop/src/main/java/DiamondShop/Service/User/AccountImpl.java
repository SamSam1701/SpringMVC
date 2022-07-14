package DiamondShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.UsersDao;
import DiamondShop.Entity.Users;

@Service
public class AccountImpl implements IAccount{
	@Autowired
	UsersDao userDao = new UsersDao();
	
	public int AddAccount(Users user)
	{
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		
		return userDao.AddAccount(user);
	}

	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = userDao.GetUserByAccount(user);
		if(user !=null)
		{
			if(BCrypt.checkpw(pass, user.getPassword()))
			{
				return user;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	
}
