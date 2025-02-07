package utility;

public class Random {
	
	public static int getNumber(int range) {
		return (int) (Math.random() * range);
	}
	
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
