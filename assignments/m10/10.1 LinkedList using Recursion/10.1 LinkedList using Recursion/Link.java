//Linkedlist classs 
public class LinkedList{
	private ListNode firstNode;
	private ListNode lastNode;
	private int size;
}
//Constructor has data and next link will be null
public LinkedList() {
	this.firstNode= new ListNode();
	this.lastNode= this.firstNode;
	this.size=0;
}
