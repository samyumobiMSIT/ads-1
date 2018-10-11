import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

 class NonrecursiveBST<Key extends Comparable<Key>, Value> {

    // root of BST
    private Node root;  

    private class Node {
        private Key key;             // sorted by key
        private Value val;           // associated value
        private Node left, right;    // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /***************************************************************************
    *  Insert key-value pair into symbol table (nonrecursive version).
    ***************************************************************************/
    public void put(Key key, Value val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return; 
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = z;
        else         parent.right = z;
    }
   

   /***************************************************************************
    *  Search BST for given key, nonrecursive version.
    ***************************************************************************/
    Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

   /***************************************************************************
    *  Inorder traversal.
    ***************************************************************************/
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new Queue<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                queue.enqueue(x.key);
                x = x.right;
            }
        }
        return queue;
    }

 public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        NonrecursiveBST<String, Integer> st = new NonrecursiveBST<String, Integer>(input.length);
        /*for (int i = 0; i < input.length; i++) {
            st.put(input[i], i);
        }*/
        while (sc.hasNextLine()) {
            String[] operation = sc.nextLine().split(" ");
            switch (operation[0]) {                
                case "put":
                for (int i = 0; i < input.length; i++)
                st.put(input[i], i);
               // System.out.println(st.contains(operation[1]));
                break;
                 case "get":
                 for (String s : st.keys())
                    System.out.println(st.get(operation[1]));
                   //System.out.println(s + " " + st.get(s));
                break;
                 default:
                break;
            }
        }
    }
}


        
    
