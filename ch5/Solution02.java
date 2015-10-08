package cc555;

public class Solution02 {
	
	static String binaryToString(double m) {
		
		// robustness
		if (m > 1 || m < 0) return "Error";
		
		
		StringBuilder result = new StringBuilder();
		
		result.append("0.");
		while (m > 0) {
			
			// can not be represented
			if (result.length() > 32) {
				return "Error";
			}
			
			double help = m * 2;
			
			if (help >= 1) {
				result.append("1");
				m = help - 1;
			} else {
				result.append("0");
				m = help;
			}
		
		}
		
		// change result type to string
		return result.toString();
		
	}

	public static void main(String[] args) {
		double in = 0.75;
		
		String result = binaryToString(in);
		
		System.out.println(result);

	}

}
