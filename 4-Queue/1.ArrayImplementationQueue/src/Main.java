
public class Main {

	public static void main(String[] args) {
		ArrayQueue<String> nations = new ArrayQueue<String>();
		nations.add("CA");
		nations.add("FR");
		nations.add("GB");
		nations.remove();
		nations.remove();
		nations.add("UK");
		nations.remove();
		nations.add("USA");
		nations.add("TN");
		nations.print();
		nations.add("HU");
		nations.print();
		System.out.println("element() : "+nations.element());
		System.out.println("isEmpty() : "+nations.isEmpty());
		System.out.println("size() : "+nations.size());
	}

}
//output
/*
	USA => TN => null => UK => 
	[USA, TN, null, UK] / front 3 / back 2 / size 3 / len 4
	[UK, USA, TN, null, null, null, null, null]
	UK => USA => TN => HU => null => null => null => null => 
	element() : UK
	isEmpty() : false
	size() : 4
*/

/*
 Instead of storing the size counter, this implementation stores front and back indexes into the array.
The front element of the queue is always at elements[front], and the back element of the queue is
always at elements[back-1] (except when back = 0). The front index is advanced each time an
element is removed from the queue (at line 44), and the back index is advanced each time an element is
added (at line 21). In both cases, when the index reaches the end of the array, it is “advanced” to 0. This
“wraps” the queue around the end of the array, like a ring, allowing array elements to be reused.
 */
 