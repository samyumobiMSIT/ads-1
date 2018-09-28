class LinkedList {
    class Node {
    /**
     * { String data }.
     */
    String data;
    /**
     * { Node next }.
     */
    Node next;
}
    /**
     * An empty node.
     */
    private Node start = null;
    /**
     * Pushing an element into list.
     *
     * @param      ch    { given String }
     */
    void push(final String ch) {
        Node val = start;
        start = new Node();
        start.data = ch;
        start.next = val;
    }
    /**
     * Popping element from list.
     *
     * @return     { String value }
     */
    String pop() {
        if (start == null) {
            return "e";
        }
        String str = start.data;
        start = start.next;
        return str;
    }
    /**
     * First value.
     *
     * @return     { value }
     */
    public Node gethead() {
        return start;
    }
}