import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> nations = new PriorityQueue<String>();
		Collections.addAll(nations, "GB","USA","FR","GER","IT","CA");
		System.out.println(nations);
		System.out.println(nations.remove());
		System.out.println(nations);
		System.out.println(nations.remove());
		System.out.println(nations);
		System.out.println(nations.add("TN"));
		System.out.println(nations);
		//using comarator
		System.out.println("PriorityQueue backed by comparator implementation class comparing the reverse of strings");
		Queue<String> queue = new PriorityQueue<String>(new CompareReverse());
		Collections.addAll(queue, "FR","TN","USA","HU","GB","CA");
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
	}

}
class CompareReverse implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1==o2)
			return 0;
		StringBuilder str1=new StringBuilder(o1);
		StringBuilder str2=new StringBuilder(o2);
		o1=str1.reverse().toString();
		o2=str2.reverse().toString();
		return o1.compareTo(o2);
	}
	
}
//output
/*
 * 
	CA
	[FR, GER, GB, USA, IT]
	FR
	[GB, GER, IT, USA]
	true
	[GB, GER, IT, USA, TN]
	PriorityQueue backed by comparator implementation class comparing the reverse of strings
	[CA, GB, USA, HU, FR, TN]
	CA
	[USA, GB, TN, HU, FR]
	USA
	[GB, FR, TN, HU]
 *
 */

/*
	A priority queue is the same as an ordinary queue except for its removal algorithm: Instead of
	removing the element that has been in the queue the longest, it removes the element that has the
	highest priority. This of course, requires its elements to be prioritized. In other words, the
	elements have to have some ordering mechanism; either a natural order, such as alphabetic order
	for strings, or an order imposed by a Comparator object. (See page 79.)
	The PriorityQueue class extends the AbstractQueue class, implementing the Queue interface. To accommodate the priority protocol, it includes a constructor for specifying a
	Comparator, a constructor for specifying a SortedSet source of elements, and an accessor
	method for obtaining the elements’ comparator:
	PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
	PriorityQueue(SortedSet<? extends E> c)
	Comparator<? super E> comparator()
	Note that the first of these two constructors requires the collection’s initialCapacity to be
	specified. That is because the PriorityQueue class is implemented with a heap data structure,
	which uses an array to store its elements
 */