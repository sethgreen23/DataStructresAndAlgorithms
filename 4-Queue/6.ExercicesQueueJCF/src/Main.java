import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> alphabet = new ArrayDeque<String>();
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		alphabet.add("D");
		Queue<String> alphabet1 = new ArrayDeque<String>();
		alphabet1.add("E");
		alphabet1.add("F");
		alphabet1.add("G");
		alphabet1.add("H");
//		System.out.println(alphabet);
//		Queue<String> reversedAlphabet = reversed(alphabet);
//		System.out.println(reversedAlphabet);
//		System.out.println(alphabet);
		
		//6.3
//		System.out.println(alphabet);
//		Queue<String> reversedAlphabet = reversed1(alphabet);
//		System.out.println(reversedAlphabet);
//		System.out.println(alphabet);
		
		//6.4
//		System.out.println(alphabet);
//		reverse(alphabet);
//		System.out.println(alphabet);
		
		//6.5
//		System.out.println(alphabet);
//		String secondElement = secondElement(alphabet);
//		System.out.println(secondElement);
		
		//6.6
//		System.out.println(alphabet);
//		String lastElement = lastElement(alphabet);
//		System.out.println(lastElement);
		
		//6.7
//		System.out.println(alphabet);
//		removeLastElement(alphabet);
//		System.out.println(alphabet);
		
		//6.8
		System.out.println(alphabet);
		System.out.println(alphabet1);
		Queue<String> merged = merge(alphabet,alphabet1);
		System.out.println(merged);

	}
	
	//6.2 Write this client method using only the methods specified in the Queue interface:
	//public static <E> Queue<E> reversed(Queue<E> queue) {
	// returns a new queue that contains the same elements as the given
	// queue, but in reversed order
	public static <E> Queue<E> reversed(Queue<E> queue){
	
		LinkedList<E> stack = new LinkedList<E>();
		Queue<E> newQueue = new ArrayDeque<E>();
		while(!queue.isEmpty()) {
			stack.push((E)queue.remove());;
		}
		while(!stack.isEmpty()) {
			newQueue.add(stack.pop());
		}
		return newQueue;
	}
	
//	6.3 Write this client method using only the methods specified in the Queue interface:
//		public static <E> Queue<E> reversed(Queue<E> queue) {
//		// returns a new queue that contains the same elements as the given
//		// queue, but in reversed order, and leaves the given queue in its
//		// original state
	
	public static <E> Queue<E> reversed1(Queue<E> queue) {
		LinkedList<E> stack = new LinkedList<E>();
		Queue<E> newQueue = new ArrayDeque<E>();
		for(int i=0;i<queue.size();i++) {
			stack.push(queue.element());
			queue.add(queue.remove());
		}
		while(!stack.isEmpty()) {
			newQueue.add(stack.pop());
		}
		return newQueue;
	}
	
//	6.4 Write this client method using only the methods specified in the Queue interface:
//		public static <E> void reverse(Queue<E> queue) {
//		// reverses the elements in the specified queue
	public static <E> void reverse(Queue<E> queue) {
		Deque<E> stack = new LinkedList<E>();
		while(!queue.isEmpty())
			stack.push(queue.remove());
			
		while(!stack.isEmpty())
			queue.add(stack.pop());
	}
	
//	6.5 Write this client method using only the methods specified in the Queue interface:
//		public static <E> E secondElement(Queue<E> queue) {
//		// returns the second element in the specified queue, leaving the
//		// queue in its original state
	public static <E> E secondElement(Queue<E> queue) {
		E element = null;
		for(int i=0;i<queue.size();i++) {
			if(i==1) {
				element = queue.element();
			}
			queue.add(queue.remove());
		}
		return element;
	}
	
//	6.6 Write this client method using only the methods specified in the Queue interface:
//		public static <E> E lastElement(Queue<E> queue) {
//		// returns the last element in the specified queue, leaving the
//		// queue in its original state
	public static <E> E lastElement(Queue<E> queue) {
		E element = null;
		for(int i=0;i<queue.size();i++) {
			if(i==queue.size()-1) {
				element = queue.element();
			}
			queue.add(queue.remove());
		}
		return element;
	}
	
//	6.7 Write this client method using only the methods specified in the Queue interface:
//		public static <E> void removeLastElement(Queue<E> queue) {
//		// removes the last element in the specified queue
	public static <E> void removeLastElement(Queue<E> queue) {
		for(int i=0;i<queue.size()-1;i++) {
			queue.add(queue.remove());
		}
		queue.remove();
	}
	
//	6.8 Write this client method using only the methods specified in the Queue interface:
//		public static <E> Queue<E> merge(Queue<E> q1, Queue<E> q2) {
//		// returns a new queue that contains the same elements as the two
//		// specified queues, alternately merged together, leaving the two
//		// specified queues in their original state
	public static <E> Queue<E> merge(Queue<E> q1, Queue<E> q2) {
		Queue<E> mergedQueue = new ArrayDeque<E>();
		
		for(int i=0;i<q1.size();i++) {
			mergedQueue.add(q1.element());
			q1.add(q1.remove());			
		}
		
		for(int i=0;i<q2.size();i++) {
			mergedQueue.add(q2.element());
			q2.add(q2.remove());			
		}
		return mergedQueue;
	}
}
