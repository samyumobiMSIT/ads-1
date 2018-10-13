/**
 * { import Scanner class}
 */
import java.util.Scanner;
/**
 * { imports Arrays class }
 */
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object for Solution class.
     */
    private Solution() {

    }
    /**
     * Representing THREE as 3.
     */
    private static final int THREE = 3;
    /**
     * main function to read input.
     * Time Complexity : O(N) (while loop).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        int count = 0;
        Team[] teamsArray = new Team[100];
        while (scan.hasNextLine()) {
        // while (true) {
            String nextLine = scan.nextLine();
            // if (nextLine.equals(".")) break;
        //     input += nextLine + "\n";
        // }
        // String[] inputLineArray = input.split("\n");
        // for (int i = 0; i < inputLineArray.length; i++) {
            String[] tokens = nextLine.split(",");
            teamsArray[i] = new Team(tokens[0], Integer.parseInt(tokens[1]),
             Integer.parseInt(tokens[2]), Integer.parseInt(tokens[THREE]));
            count++;
        }
        /**
     * method to perform selection sort
     * Time Complexities .
     * Best - O(N)
     * Worst - O(N)
     * Average - O(N)
     *
     */
        Selectionsort ss = new Selectionsort();
        ss.sort(teamsArray);
        System.out.println(Arrays.toString(teamsArray).replace(" ", "")
            .replace("[", "").replace("]", ""));

    }
}