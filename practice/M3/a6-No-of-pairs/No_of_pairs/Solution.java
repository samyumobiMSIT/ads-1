import java.util.Scanner;



/**

 * Class for solution.

 */

public final class Solution {



    /**

     * Constructs the object.

     */

    private Solution() {



    }



    /**

     * main method prints the no of pairs.

     *

     * @param      args  The command line arguments

     */

    public static void main(final String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] array;

        array = new int[n];

        for (int i = 0; i < n; i++) {

            array[i] = input.nextInt();

        }

        pairCounter(array, n);

    }



    /**

     * counts the no of pairs in an array.

     *

     * @param      array  The array

     * @param      n      length of array.

     */

    public static void pairCounter(final int[] array, final int n) {

        int totalpairs = 0;

        //every element in the object will bve observed atleast once.

        int observation = 1;



        for (int i = 0; i < n; i++) {

            if (i < n - 1 && array[i] == array[i + 1]) {

                observation++;

            } else {

                if (observation > 1) {

                    totalpairs += observation * (observation - 1) / 2;

                }

                //resetting the observation to one.

                observation = 1;

            }

        }

        System.out.println("number of pairs " + totalpairs);

    }

}