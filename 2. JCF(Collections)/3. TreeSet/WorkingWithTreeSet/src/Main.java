import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet<String> nations = new TreeSet<String>(new CompareWithReverse());
		Collections.addAll(nations, "JP","FR","GB","USA","RUS","CA","CHN","HU","GER");
		System.out.println("using iterator to display TreeSet");
		for(Iterator<String> iterator=nations.iterator();iterator.hasNext();) {
			System.out.printf("%s", iterator.next());
			System.out.print(iterator.hasNext()?", ":"\n");
		}
		//using methods related to 
		nations = new TreeSet<String>();
		Collections.addAll(nations, "JP","FR","GB","USA","RUS","CA","CHN","HU","GER");
		System.out.println(nations);
		SortedSet<String> head = nations.headSet("GB");
		SortedSet<String> mid = nations.subSet("GB","JP");
		SortedSet<String> tail = nations.tailSet("JP");
		System.out.println(head);
		System.out.println(mid);
		System.out.println(tail);
	}

}
//output
/*
	 using iterator to display TreeSet
	CA, USA, GB, CHN, JP, GER, FR, RUS, HU
	[CA, CHN, FR, GB, GER, HU, JP, RUS, USA]
	[CA, CHN, FR]
	[GB, GER, HU]
	[JP, RUS, USA]
 */

/*
 In Java, there are two ways for objects to be compared: either by means of their natural ordering or by the application of an external Comparator object. Classes whose objects enjoy a
natural order implement the comparable interface.

User-defined orderings can be defined for a class by implementing the Comparator interface,
which is part of the JCF. It specifies a compare() method, which returns an int that indicates
how its two arguments are ordered: compare(x,y) > 0 means that x is greater than y,
compare(x,y) < 0 means that x is less than y, and compare(x,y) == 0 means that x equals y.
A Comparator object can be passed to a SortedSet constructor to specify how the elements
should be ordered.
 */

/*
 The intrinsic difference between the HashSet and TreeSet classes is their backing data structure. The HashSet class uses a hash table (outlined in Chapter 8), which uses each element’s
hashCode() to compute its location in the set. The TreeSet class uses a balanced binary search
tree (outlined in Chapter 12) to store its elements. The advantages and disadvantages of these
two data structures are summarized in Table 4.2.
These relative advantages and disadvantages make the choice easy: If you want to preserve the
natural order of the elements in your set, use the TreeSet class; otherwise, use the HashSet class
 */
 */