import java.util.Scanner;
import java.util.Arrays;

public final class Solution {

    
    private static final int THREE = 3;

    
    private Solution() {

    }

    
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        StringBuffer b = new StringBuffer();
        while (scan.hasNext()) {
            b.append(scan.nextLine() + "::");
        }
        String[] lines = b.toString().split("::");
        Team[] teams = new Team[lines.length];
        for (String line : lines) {
            String[] tokens = line.split(",");
            teams[i++] = new Team(tokens[0],
                                  Integer.parseInt(tokens[1]),
                                  Integer.parseInt(tokens[2]),
                                  Integer.parseInt(tokens[THREE]));
        }
        Selection.sort(teams);
        String output = Arrays.toString(teams).replace("[", "").
                        replace("]", "").replace(", ", ",");
        System.out.println(output);
    }
}