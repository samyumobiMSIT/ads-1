public class Solution{
	 private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static Boolean isBalanced(String s){
    	Stack<Character> Stack = new Stack<Character>();
    	for(int i=0; i<s.length();i++){
    		if(s.charAt(i) == LEFT_PAREN)
    			Stack.push(LEFT_PAREN);
    		if(s.charAt(i)== RIGHT_PAREN)
    			Stack.push(LEFT_BRACE);
    		if(s.charAt(i) == LEFT_BRACKET)
    			Stack.push(LEFT_BRACKET);

    		if(s.charAt(i)== RIGHT_PAREN){
    			if(Stack.isEmpty())
    				return false;
    			if(Stack.pop()!= LEFT_PAREN)
    				return false;
    		}
    		else if(s.charAt(i) == RIGHT_BRACE){
    			if(Stack.isEmpty())
    				return false;
    			if(Stack.pop()!= LEFT_BRACE)
    				return false;
    		}
    		else if(s.charAt(i) == RIGHT_BRACKET){
    			if(Stack.isEmpty())
    				return false;
    			if(Stack.pop()!= LEFT_BRACKET)
    				return false;
    		}
    	}
    	return Stack.isEmpty();
    }

public static void public static void main(String[] args) {
	 In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
}

}