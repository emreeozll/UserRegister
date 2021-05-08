package DataAccess.concretes;

import java.util.List;
import java.util.ArrayList;
import DataAccess.abstarct.UserDao;
import Entities.concretes.User;
import core.abstarct.VerifyingCodeService;



public class ActivityUserDao implements UserDao {
	
	List<User> userList = new ArrayList<>();
	

	
	@Override
	public void addUser(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " adlý kullanýcý baþarýlý bir þekilde eklendi.");
      
		userList.add(user);
	}

	@Override
	public void deleteUser(User user) {
		
		System.out.println(user.getFirstName()+" "+user.getLastName()+" adlý kullanýcý silindi.");

	}

	@Override
	public void updateUser(User user) {
		
		System.out.println(user.getLastName()+" "+user.getLastName()+" adlý kullanýcý güncellendi.");

	}


	@Override
	public User get(int id) {
		
		return this.userList.get(id);
	}

	@Override
	public List<User> getAll() {
	
		return userList;
	}


	@Override
	public String getAllEmail(String mail) {

		String mailToReturn = null;
		
		for (User user : userList) {
		
             if(user.getEmail().equals(mail)) {
            	 
            	 mailToReturn = mail;
                 break;
             }			
             
		}
		return mailToReturn;
		
		
	}

	

}
