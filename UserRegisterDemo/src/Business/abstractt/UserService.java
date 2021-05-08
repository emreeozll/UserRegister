package Business.abstractt;

import java.util.List;

import Entities.concretes.User;

public interface UserService {

	
	
	void register(User user);
	
	
	void userlogin(String email, String password);
	
	
	void loginWithGoogle(String mail, String password);
	
	List<User> getallUsers();
	
	
	String getEmail(String mail);
}
