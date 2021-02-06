import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<String> nations = new HashSet<String>();
		Collections.addAll(nations, "JP","GB","USA","IT","FR","CA");
		System.out.println(nations);
		//create iterator for nations and parse and delete elements along the way
		Iterator iterator = nations.iterator();
		System.out.printf("element one : %s%n",iterator.next());
		System.out.printf("element two : %s%n",iterator.next());
		System.out.println("remove: ");iterator.remove();
		System.out.println(nations);
		System.out.printf("element three : %s%n",iterator.next());
		System.out.println("remove: ");iterator.remove();
		System.out.println(nations);
		//create second iterator for nations hashset and print all its elements
		Iterator iterator1 = nations.iterator();
		for(;iterator1.hasNext();)
			System.out.printf("%s, ",iterator1.next());
		System.out.println("");
		//continue printing out the elements of nations using the first iterator
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}

}

//output
/*
	[USA, JP, GB, IT, FR, CA]
	element one : USA
	element two : JP
	remove: 
	[USA, GB, IT, FR, CA]
	element three : GB
	remove: 
	[USA, IT, FR, CA]
	USA, IT, FR, CA, 
	IT
	FR
	CA
 */
/*
 * iterator has the capability of moving from one element to the next and of deleting its current element
 * 
 * it is possible to have several independent iterators traversing the same collection
 * 
 * The algorithm that determines each “next” element in the iterator’s path is an intrinsic
property of the iterator itself. Moreover, it is possible to have several different iterator classes
defined for the same collection class, each with its own traversal algorithms.
 */