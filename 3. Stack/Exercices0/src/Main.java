import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Deque<String> nations = new ArrayDeque<String>();
		nations.push("FR");
		nations.push("GB");
		nations.push("USA");
		nations.push("RUS");
		nations.push("CH");
//		print(nations);
//		Deque<String> reversedNations = reversed(nations);
//		print(reversedNations);
		
//		Deque<String> reversedNations = reversed_2(nations);
//		print(reversedNations);
		
//		print(nations);
//		reverse(nations);
//		print(nations);
		
//		print(nations);
//		String second = penultimate(nations);
//		System.out.println(second);
//		print(nations);

//		print(nations);
//		String second = popPenultimate(nations);
//		System.out.println(second);
//		print(nations);
		
//		print(nations);
//		String last = bottom(nations);
//		System.out.println(last);
//		print(nations);
		
		print(nations);
		String last = popBottom(nations);
		System.out.println(last);
		print(nations);
		
		
		
	}
	

	
//	5.14 Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//		public static <E> E popBottom(Deque<E> stack)
//		// removes and returns the bottom element of the specified stack
	public static <E> E popBottom(Deque<E> stack) {
		Deque<E> reversed = new ArrayDeque<E>();
		while(!stack.isEmpty()) {
			reversed.push(stack.pop());
		}
		E last = reversed.pop();
		while(!reversed.isEmpty()) {
			stack.push(reversed.pop());
		}
		return last;
	}
	
//	5.13 Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//		public static <E> E bottom(Deque<E> stack)
//		// returns the bottom element of the specified stack
	public static <E> E bottom(Deque<E> stack) {
		Deque<E> reversed = new ArrayDeque<E>();
		while(!stack.isEmpty()) {
			reversed.push(stack.pop());
		}
		E last = reversed.peek();
		while(!reversed.isEmpty()) {
			stack.push(reversed.pop());
		}
		return last;
	}
	
//	5.12 Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//		public static <E> E popPenultimate(Deque<E> stack)
//		// removes and returns the second element of the specified stack
	public static <E> E popPenultimate(Deque<E> stack) {
		E first = stack.pop();
		E second = stack.pop();
		stack.push(first);
		return second;
	}
	
//	5.11 Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//		public static <E> E penultimate(Deque<E> stack)
//		// returns the second from the top element of the specified stack
	public static <E> E penultimate(Deque<E> stack) {
		E element = stack.pop();
		E second = stack.peek();
		stack.push(element);
		return second;
	}

//	Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//	public static <E> void reverse(Deque<E> stack)
//	// reverses the contents of the specified stack

public static <E> void reverse(Deque<E> stack) {
	Deque<E> reverse = new ArrayDeque<E>();
	Deque<E> normal = new ArrayDeque<E>();
	while(!stack.isEmpty()) {
		reverse.push(stack.pop());
	}
	
	while(!reverse.isEmpty()) {
		normal.push(reverse.pop());
	}
	
	
	while(!normal.isEmpty()) {
		stack.push(normal.pop());
	}
	
}
	
	
//	Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//		public static <E> Deque<E> reversed(Deque<E> stack)
//		// returns a new stack that contains the same elements as the given
//		// stack, but in reversed order
	public static <E> Deque<E> reversed(Deque<E> stack){
		Deque<E> reversed = new ArrayDeque<E>();
		
		while(!stack.isEmpty()) {
			reversed.push(stack.pop());
		}
		
		return reversed;
	}
	
	
//	Write this client method using only the push(), peek(), pop(), and isEmpty() methods:
//		public static <E> Deque<E> reversed(Deque<E> stack)
//		// returns a new stack that contains the same elements as the given
//		// stack, but in reversed order, and leaves the given stack in its
//		// original state
	
	public static <E> Deque<E> reversed_1(Deque<E> stack){
		Deque<E> reversed = new ArrayDeque<E>();
		Iterator iterator = stack.iterator();
		for(;iterator.hasNext();) {
			reversed.push((E)iterator.next());
		}
		
		return reversed;
	}
	public static <E> Deque<E> reversed_2(Deque<E> stack){
		Deque<E> reversed = new ArrayDeque<E>();
		Deque<E> stack1 = new ArrayDeque<E>();
		Iterator iterator = stack.iterator();
		
		while(!stack.isEmpty()) {
			reversed.push(stack.peek());
			stack1.push(stack.pop());
		}
		
		while(!stack1.isEmpty()) {
			stack.push(stack1.pop());
		}
		return reversed;
	}
	

	
	public static <E> void print(Deque<E> stack){
		for(E element : stack) {
			System.out.printf("%s => ",element);
		}
		System.out.println();
	}
}
