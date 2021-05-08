package core.concretes;

import java.util.Random;
import java.util.Scanner;

import core.abstarct.VerifyingCodeService;

public class CodeServiceManager implements VerifyingCodeService {

	@Override
	public void verifyingcode() {
		
		System.out.println(" ");
		System.out.println("******************Kullanýcý Doðrulama Sistemi******************");
		Random random = new Random();
		int code = random.nextInt(1000);
		
		String code2 = Integer.toString(code);
				
		System.out.println("Verifying Code : "+ code);
		
		System.out.println("Kayýt doðrulama için size gönderiken doðrulama kodunu giriniz:");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Size gönderilen kodu giriniz:");
		
		String codeinput = scanner.nextLine();
		
		if(code2.equals(codeinput)) {
			
			System.out.println("Code verified and login completed successfully");
		}else {
			System.out.println("The code could not be verified");
			
		}
		
	}

	
	
}
