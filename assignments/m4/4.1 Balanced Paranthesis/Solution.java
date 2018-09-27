import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution{
	public static void main(String[] a){
		String expr = readInput();
		System.out.println("Valid: "+validate(expr));
	}
	public static boolean validate(String expr){
		if (null == expr) { return true; }
		Stack<Character> stack = new Stack<Character>();
		int len = expr.length();
		if (0 == len) { return true; }
		
		for (int i=0; i<len; i++) {
			char ch = expr.charAt(i);
			if (isStarting(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) { return false; }
				char top = stack.peek();
				char tmp = getMatching(top);
				if (tmp == ch) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
		

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