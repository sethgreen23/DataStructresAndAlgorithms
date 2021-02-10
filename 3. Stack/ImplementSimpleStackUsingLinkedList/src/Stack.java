import java.util.EmptyStackException;
import java.util.List;

public class Stack {
	private Node head;
	//add list of players to the stack
	public void addList(List<Player> arr) {
		for(Player element : arr) {
			push(element);
		}
	}
	
	//add a player to the stack
	public  void push(Player element) {
			Node newNode = new Node(element,head);
			head=newNode;		
	}
	
	//peek the head without pooping it
	public Player peek() {
		return head.getP();
	}
	
	//remove the first Node of the list
	public Player pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		Node removeNode = head;
		head = head.next;
		removeNode.next=null;
		return removeNode.getP();
	}
	
	/*
	 * HELPER FUNCTIONS
	 * print()
	 * isEmpty()
	 * 
	 */
	
	//print the stack
	public void print() {
		Node parser = head;
		System.out.print("Head -> ");
		while(parser!=null) {
			System.out.print(parser.getP()+" -> ");
			parser = parser.next;
		}
		System.out.println("Null");
	}
	
	//check if the stack is empty
	public boolean isEmpty() {
		return head == null;
	}
	
	//static node the main componenet of the stack
	static class Node{
		Player p;
		Node next;
		public Node(Player p) {
			this.p=p;
		}
		public Node(Player p, Node next) {
			this.next = next;
			this.p = p;
		}
		public Player getP() {
			return p;
		}
		public void setP(Player p) {
			this.p = p;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
}
