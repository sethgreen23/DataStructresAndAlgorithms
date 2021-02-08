import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Deque<String> nations = new ArrayDeque<String>();
		Collections.addAll(nations, "Fr","GB","USA","HU","GER","RUS");
		System.out.println(nations);
		System.out.println("Remove First : "+nations.removeFirst());
		System.out.println(nations);
		System.out.println("Remove Last : "+nations.removeLast());
		System.out.println(nations);
		System.out.println("Iteate throw the elements using iterator: ");
		Iterator iterator = nations.iterator();
		System.out.print("{");
		for(;iterator.hasNext();) {
			System.out.printf("%s", iterator.next());
			System.out.print(iterator.hasNext()?", ":"}\n");
		}
	}

}
//output
/*
	[Fr, GB, USA, HU, GER, RUS]
	Remove First : Fr
	[GB, USA, HU, GER, RUS]
	Remove Last : RUS
	[GB, USA, HU, GER]
	Iteate throw the elements using iterator: 
	{GB, USA, HU, GER}
 */

/*
	A deque (pronounced “deck”) is a double-ended queue, that is, a linear data structure that
	allows insertions and deletions at both ends but nowhere else.
	The Deque interface extends the Queue interface. (See Figure 4.1 on page 70.) In addition to
	the 15 methods specified by the Collection interface and the 5 more methods specified by the
	Queue interface, the Deque interface specifies these 17 methods:
	void addFirst(E e)
	void addLast(E e)
	Iterator<E> descendingIterator()
	E getFirst()
	E getLast()
	boolean offerFirst(E e)
	boolean offerLast(E e)
	E peekFirst()
	E peekLast()
	E pollFirst()
	E pollLast()
	E pop()
	void push(E e)
	E removeFirst()
	E removeLast()
	boolean removeFirstOccurrence(Object o)
	boolean removeLastOccurrence(Object o)
	Notice how these methods come in pairs, one each for each end of the deque: first for the front
	of the deque, and last for the back.
	The descendingIterator() method is the same as the iterator() method, except that it
	moves in the opposite direction.
	The pop() and push() methods are the same as the removeFirst() and addFirst()
	methods, respectively. They are the traditional names for the insert and delete methods for a
	stack data structure, which is a deque that allows access at only one end. (See Chapter 5.)
	The ArrayDeque class implements the Deque interface by using a resizable array to store its
	elements. The Deque interface and its ArrayDeque implementation were added to the JCF with
	Java 6.
 * */
 