import java.util.Scanner;

import java.util.Arrays;

/**

 * Class for solution.

 */

public final class Solution {

    /**

     * Constructs the object.

     */

    private Solution() {

        //Solution.

    }

    /**

     * { function_description }.

     *

     * @param      args  The arguments

     */

    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);

        int len1 = scan.nextInt();

        int len2 = scan.nextInt();

        int totallen = len1 + len2;

        String[] arr1 = new String[len1];

        if (len1 > 0) {

            arr1 = scan.next().split(",");

        } else {

            scan.nextLine();

        }

        String[] arr2 = scan.next().split(",");

        int[] array1 = new int[len1];

        int[] array2 = new int[len2];

        int[] array = new int[totallen];

        for (int i = 0; i < len1; i++) {

            array1[i] = Integer.parseInt(arr1[i]);

        }

        for (int i = 0; i < len2; i++) {

            array2[i] = Integer.parseInt(arr2[i]);

        }

        int i = 0;

        int j = 0;

        int k = 0;

        for (k = 0; k < totallen; k++) {

            if (i < len1 && j < len2 && len1 > 0 && len2 > 0) {

                if (array1[i] < array2[j]) {

                    array[k] = array1[i];

                    i++;

                } else if (array1[i] > array2[j]) {

                    array[k] = array2[j];

                    j++;

                }

            } else {

                if (len1 > len2) {

                    array[k] = array1[i];

                    i++;

                } else {

                    array[k] = array2[j];

                    j++;

                }

            }

        }

        String str = Arrays.toString(array);

        System.out.println(str.replace("[", "").replace("]", "").

            replace(", ", ","));

    }

}