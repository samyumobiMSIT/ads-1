/**
     * To perform selection sort.
     *
     * @param      team  The teams
     * @param      size   The size
     *
     * @return     sorted array of team objects
     * Time complexity of This method is O(N^2)
     *  because we are using nested for loops
     *   in worst case it may go up to O(N^2)
     */
public static void selectionSort() {
        for (int i = students.size() - 1; i >= 0; i--) {
            Student max = students.get(i);
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(students.get(j)) == 1) {
                    max = students.get(j);
                    index = j;
                }
            }
            Student temp = students.get(i);
            students.set(i, max);
            if (index != -1) {
                students.set(index, temp);
            }
        }
    }

