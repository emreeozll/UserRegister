package Business.concretes;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;

import Business.abstractt.UserService;
import DataAccess.abstarct.UserDao;
import DataAccess.concretes.ActivityUserDao;
import Entities.concretes.User;
import core.abstarct.GoogleService;
import core.abstarct.VerifyingCodeService;

public class UserServiceManager implements UserService {

	private UserDao userDao;
    private VerifyingCodeService codeService;
	private GoogleService googleService;
    
	
	public UserServiceManager(UserDao userDao, VerifyingCodeService codeService, GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.codeService= codeService;
		this.googleService = googleService;

		
	}

	public static boolean isEmailValid(String emailInput) {
		final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

	@Override
	public void register(User user) {

		if (user.getPassword().length() < 6) {
			System.out.println("The password must be at least 6 characters.");
                  return;
                  
		} else if (isEmailValid(user.getEmail()) == false) {
			System.out.println("Entered mail is wrong");
		           return;
		           
		}else if (user.getFirstName().length() < 2 && user.getLastName().length() < 2) {
			System.out.println("Username is small in number of characters.");
		          return;
		          
		}else if (getEmail(user.getEmail()) != null) {

			System.out.println("This email is in use");
			
			return;
			
		} else {

		    
			System.out.println("Email registration successful");
			this.userDao.addUser(user);
			this.codeService.verifyingcode();
			
		}
		

	}

	@Override
	public void userlogin(String email, String password) {

	      for (User user : this.userDao.getAll()) {
	    	  
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				
				System.out.println("Succesful Login the System");
				
			break;
			}
			
			}

	}

	@Override
	public List<User> getallUsers() {

		return this.userDao.getAll();
	}

	@Override
	public String getEmail(String mail) {

		return this.userDao.getAllEmail(mail);
	}

	@Override
	public void loginWithGoogle(String mail, String password) {

		 for (User user : this.userDao.getAll()) {
	    	  
				if(user.getEmail().equals(mail) && user.getPassword().equals(password)) {
					
					System.out.println("Succesful Login the System");
					
					googleService.loginWithGoogle(mail, password);
					this.codeService.verifyingcode();
				break;
				}
				
	}

	}
}
