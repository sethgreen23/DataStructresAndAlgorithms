import java.util.AbstractQueue;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedQueue<String>();
		Collections.addAll(queue, "AR", "BO", "CO", "EC");
		System.out.println(queue);
		String firstOut = queue.remove();
		System.out.println(queue);
		System.out.printf("Removed %s%n", firstOut);
		queue.add("PE");
		System.out.println(queue);
		String secondOut = queue.remove();
		System.out.println(queue);
		System.out.printf("Removed %s%n", secondOut);
		}
}

class LinkedQueue<E> extends AbstractQueue<E> implements Queue<E> {

	private List<E> list = new LinkedList<E>();
	
	@Override
	public boolean offer(E e) {
		if (e == null) {
			return false;
		} else {
			list.add(e);
			return true;
		}
	}

	@Override
	public E poll() {
		if (list.isEmpty()) {
			 return null;
		 } else {
			 return list.remove(0);
		 }
	}

	@Override
	public E peek() {
		return list.get(0);
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public int size() {
		return list.size();
	}
	
 }

/*
 The LinkedQueue class uses a LinkedList to store its elements at line 18. This is called composition
of classes; a LinkedQueue object is composed of a LinkedList object. It allows the composing class’s
methods to be implemented using the component class’s methods. Thus, offer() uses list.add() at
line 28, peek() uses list.get() at line 34, poll() uses list.remove() at line 41, and size() uses
list.size() at line 46.
The action of the main() method illustrates the FIFO nature of a queue: Insert elements at the back and
remove them from the front. Thus, the first in (AR) was the first out (at line 6), and the second in (BO) was
the second out (at line 11).
 * */
