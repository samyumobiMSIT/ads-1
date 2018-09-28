class Balanced {
    /**
     * Constructs the object.
     */
    Balanced() {

    }
    /**
     * Checking if the pair is matched or not.
     *
     * @param      str1  The string 1
     * @param      str2  The string 2
     *
     * @return     { a boolean }
     */
    boolean Matchingpair (String str1, String str2) {
        if (str1.equals("(") && str2.equals(")")) {
            return true;
        }
        if (str1.equals("[") && str2.equals("]")) {
            return true;
        }
        if (str1.equals("{") && str2.equals("}")) {
            return true;
        }
        return false;
    }
    /**
     * Balancing of parnathesis.
     *
     * @param      array  The array
     *
     * @return     { boolean based on matching }
     */
    boolean balancing(final String[] array) {
        LinkedList ll = new LinkedList();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(") || array[i].equals("[") || array[i].equals("{")) {
                ll.push(array[i]);
            }
            if (array[i].equals(")") || array[i].equals("]") || array[i].equals("}")) {
                if (Matchingpair(ll.pop(), array[i])) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return ll.gethead() == null;
    }
}