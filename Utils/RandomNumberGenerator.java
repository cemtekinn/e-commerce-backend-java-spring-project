package Utils;

import java.util.Random;

public class RandomNumberGenerator {
	public static int randomNumber(int numberOfDigit) {
		Random random=new Random();
		int min = (int) Math.pow(10, numberOfDigit - 1);
		int max = (int) Math.pow(10, numberOfDigit) - 1;
		return random.nextInt(max - min + 1) + min;		
	}
	
}
