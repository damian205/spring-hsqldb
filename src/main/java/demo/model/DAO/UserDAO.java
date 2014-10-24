package demo.model.DAO;

import demo.model.User;

public interface UserDAO {
	
	User findByUserName(String username);

}
