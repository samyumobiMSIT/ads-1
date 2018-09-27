public class Solution{
	public static void main(String[] a){
		String exp = readInput();
		System.out.println("Valid: "+validate(expr));
	}
	public static boolean validate(String exp){

	}

	public static char getMatching(char ch){
		if (ch == '(') { return ')'; }
		if (ch == '{') { return '}'; }
		if (ch == '[') { return ']'; }
		if (ch == '<') { return '>'; }
		return '0';
	}
}