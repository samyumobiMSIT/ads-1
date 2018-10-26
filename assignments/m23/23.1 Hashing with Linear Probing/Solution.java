import java.util.Scanner;
import java.io.File;
class LinearProbing<Key, Value>{
    private static final  int capacity = 4;
    private Key[] keys;
    private Value[] values;
    /**
     *number of key-value pairs in table.
     */
    private int keyValuePairs;
    /**
     *size of the table.
     */
    private int length;
    public LinearProbing(){
        this(capacity);
    }
    LinearProbing(int capacity){
        length = capacity;
        keyValuePairs = 0;
        keys = (Key[]) new Object[length];
        values = (Value[]) new Object[length];
    }
    private int hash(Key key){
        return ((11 * key.hashCode()) % length);
    }
    public boolean contains(Key key){
        return get(key) != null;
    }
    public void resize(int capacity){
    LinearProbing<Key, Value> temp
    = new LinearProbing<Key, Value>(capacity);
    for(int i = 0; i < length; i++){
        if(keys[i] != null){
            temp.put(keys[i], values[i]);
        }
    }
    keys = temp.keys;
    values = temp.values;
    length = temp.length;
    }
    public void put(Key key, Value value){
        if(keyValuePairs >= (length / 2)) {
            resize(2 * length);
        }
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % length){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
        }
        }
        keys[i] = key;
        values[i] = value;
        keyValuePairs++;
    }
    public Value get(Key key){
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % length){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }
    public void delete(Key key){
        if (!contains(key)) return;
        int i;
        for(i = hash(key); !keys[i].equals(key); i = (i + 1) % length){
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % length;
        while(keys[i] != null){
            Key tempKey = keys[i];
            Value tempValue = values[i];
            keyValuePairs--;
            keys[i] = null;
            values[i] = null;
            put(tempKey, tempValue);
            i = (i + 1) % length;
        }
        keyValuePairs--;
        if(keyValuePairs >= 0 && keyValuePairs <= length / 8){
            resize(length / 2);
        }
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < length; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }
    public void display(){
        String str = "{";
        if(keyValuePairs == 0){
            System.out.println("{}");
            return;
        }
        for(Key s : keys()) {
            str += s + ":" + get(s) + ", ";
        }
        String strOne = str.substring(0, str.length() - 2) + "}";
        System.out.println(strOne);
    }
}

class Solution{
    Solution(){

    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinearProbing<String, Integer> object = new LinearProbing<String, Integer>();
        while(scan.hasNext()){
            String[] tokens = scan.nextLine().split(" ");
            switch(tokens[0]) {
                case "put":
                    object.put(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case "get":
                    System.out.println(object.get(tokens[1]));
                    break;
                case "delete":
                    object.delete(tokens[1]);
                    break;
                case "display":
                    object.display();
                    break;
                default: break;
            }
        }
    }
}