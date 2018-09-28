import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n != 0) {
            String[] input = sc.nextLine().split("");
        Solution b = new Solution();
            if (b.balancing(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            n--;
        }
    }
}
