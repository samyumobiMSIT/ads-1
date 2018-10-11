import java.util.Scanner;
/** Solution class **/
class Solution{
	public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        BinarySearchST st = new BinarySearchST(input.length);
        for (int i = 0; i < input.length; i++) {
            st.put(input[i], i);
        }
        while (sc.hasNextLine()) {
            String[] operation = sc.nextLine().split(" ");
            switch (operation[0]) {
            case "put":
                System.out.println(st.put(operation[1]));
                break;
            case "get":
                System.out.println(st.get(operation[1]));
                break;
           
            default:
                break;
            }
        }
    }
}
