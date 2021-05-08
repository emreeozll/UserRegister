import Business.abstractt.UserService;
import Business.concretes.UserServiceManager;
import DataAccess.concretes.ActivityUserDao;
import Entities.concretes.User;
import core.abstarct.GoogleService;
import core.abstarct.VerifyingCodeService;
import core.concretes.CodeServiceManager;
import core.concretes.GoogleServiceManager;

public class Main {

	public static void main(String[] args) {
	
		
		
		User user1 = new User(1, "Emre", "Özel", "ozel@gmail.com", "ozel123");
		User user2 = new User(2, "Ahmet", "Bekir", "bekir@gmail.com", "ozel123");
		
		
		UserService userManager = new UserServiceManager(new ActivityUserDao(),new CodeServiceManager(), new GoogleServiceManager()); 
			
		
		
	


		userManager.register(user1);
		
		System.out.println(" ");
		System.out.println("--------------------------------------------------");
		System.out.println(" ");
		
		userManager.register(user2);
		
	    System.out.println("-------------------------------------------------------");
		
		
		userManager.loginWithGoogle("ozel@gmail.com", "ozel123");
	}

}
