package DataAccess.abstarct;

import java.util.List;

import Entities.concretes.User;

public interface UserDao {

	
	
	
	void addUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	
	
	
	User get(int id);
	
	List<User> getAll();
	
	
	String getAllEmail(String mail);
	
}
