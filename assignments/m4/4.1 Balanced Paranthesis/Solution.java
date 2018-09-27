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
	public static boolean isStarting(char ch) {
		if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
			return true;
		}
		return false;
	}
	public static String readInput() {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String  str = null;
		try {
			str = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}