package algorithm.problems.backtracking;

public class StringMatchingKMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aaaaaad";
		String pattern="aad";
		System.out.println(findMatch(input,pattern));	
	}

	private static boolean findMatch(String input, String pattern) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0;i<input.length();i++) {
			boolean isMatch  = true;
			int temp = i;
			for(int j = 0;j<pattern.length();j++) {
				count++;
				if(pattern.charAt(j) != input.charAt(temp)) {
					System.out.println("Not Matched : j = "+pattern.charAt(j)+": i = "+input.charAt(temp));
					isMatch = false;
					break;
				}
				else
						temp++;				
			}	
			
			if(isMatch) {
				System.out.println(count);
				return isMatch;
			}
		}
		
		return false;
	}
	private static boolean findMatchKPM(String input, String pattern) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(int i = 0;i<input.length();i++) {
			boolean isMatch  = true;
			int temp = i;
			for(int j = 0;j<pattern.length();j++) {
				count++;
				if(pattern.charAt(j) != input.charAt(temp)) {
					System.out.println("Not Matched : j = "+pattern.charAt(j)+": i = "+input.charAt(temp));
					isMatch = false;
					break;
				}
				else
						temp++;				
			}	
			
			if(isMatch) {
				System.out.println(count);
				return isMatch;
			}
		}
		
		return false;
	}
}

