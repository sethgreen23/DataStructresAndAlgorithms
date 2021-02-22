import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> nations = new ArrayDeque<String>();
		nations.add("FR");
		nations.add("HU");
		nations.add("GB");
		nations.add("USA");
		nations.add("CA");
		System.out.println(nations);
		System.out.println("Peek the first intered element 'nations.element()' : "+nations.element());
		System.out.println("Remove the first entered element 'nations.remove()': "+nations.remove());
		System.out.println(nations);
		
	}
	public static void  print(Queue<String> nations) {
		while(!nations.isEmpty()) {
			System.out.printf("%s => ", nations.remove());
		}
	}

}

//output
//[FR, HU, GB, USA, CA]
//Peek the first intered element 'nations.element()' : FR
//Remove the first entered element 'nations.remove()': FR
//[HU, GB, USA, CA]

/*
The fundamental operations of a queue are:
1. Add an element to the back of the queue.
2. Access the current element at the front of the queue.
3. Remove the current element at the front of the queue.
 */
 
/*
the Java Collections Framework includes a Queue interface, which is implemented by four classes: the LinkedList class, the AbstractQueue class,
the PriorityQueue class, and the ArrayDeque class. For simple FIFO queues, the ArrayDeque
class is the best choice:
Queue<String> queue = new ArrayDeque<String>();
*/

/*
it is easy to
see that the only operational difference between a queue and a stack is the access point. With a
queue, it is at the front, where the “oldest” element—the one that has been there the longest—is
found. With a stack, it is at the top, where the “youngest” element—the one that arrived most
recently—is found.
*/
 