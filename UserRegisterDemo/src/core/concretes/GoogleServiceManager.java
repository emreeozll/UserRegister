package core.concretes;

import Google.concretes.ControlService;
import core.abstarct.GoogleService;

public class GoogleServiceManager implements GoogleService{

	@Override
	public void loginWithGoogle(String mail, String password) {
		
		ControlService controlService = new ControlService();
		controlService.googleAccountLogin(mail, password);
		
		
	}

}
