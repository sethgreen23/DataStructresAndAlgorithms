import java.util.Iterator;
import java.util.LinkedList;

public class Stack {
	private LinkedList<Character> stack ;
	
	public Stack() {
		stack = new LinkedList<Character>();
	}
	
	public void pushWord(String word) {
		for(char c : word.toCharArray()) {
			stack.push(c);
		}
	}
	
	public void push(Character c) {
		stack.push(c);
	}
	
	public Character pop() {
		return stack.pop();
	}
	
	public Character peek() {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void print() {
		for(Iterator<Character> iterator = stack.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
	
	public Iterator<Character> iterator(){
		return stack.iterator();
	}
	
}
