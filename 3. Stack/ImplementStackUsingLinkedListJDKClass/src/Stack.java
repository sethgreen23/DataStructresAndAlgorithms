import java.util.Iterator;
import java.util.LinkedList;

public class Stack {

	private LinkedList<Player> stack ;
	
	public Stack() {
		stack = new LinkedList<Player>();
		
	}
	
	//push method
	public void push(Player e) {
		stack.push(e);
	}
	
	//pop method 
	public Player pop() {
		return stack.pop(); 
	}
	
	//peek method
	public Player peek() {
		return stack.peek();
	}
	
	//isEmptey method
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	//print the stack
	public void print() {
		Iterator<Player> iterator = stack.iterator();
		for(;iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}
