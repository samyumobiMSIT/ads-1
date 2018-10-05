import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList list = new LinkedList();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "insertAt":
                    if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                        tokens[1]) > list.size() + 1) {
                        System.out.println(
                            "Can't insert at this position.");
                    } else {
                        list.insertAt(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                        System.out.println(list.toString());
                    }
                break;
                case "reverse":
                    if (!list.isEmpty()) {
                        list.reverse();
                        System.out.println(list.toString());
                    } else {
                        System.out.println("No elements to reverse.");
                    }
                break;

                default:
                break;
        }
    }
  }
}