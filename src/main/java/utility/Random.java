package utility;

public class Random {
	
	// getNumber method to generate a random number within the range
	public static int getNumber(int range) {
		return (int) (Math.random() * range);
	}
	
	// getString method to generate a random string of the specified length
	public static String getString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = getNumber(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

}
