package common;

import java.util.Random;

public class OtherFunction {
	
	public static int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
