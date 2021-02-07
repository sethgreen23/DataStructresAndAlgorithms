import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<String> nations = new LinkedHashSet<String>();
		Collections.addAll(nations, "IT","FR","GB","USA");
		System.out.println(nations);
		nations.remove("GB");
		System.out.println(nations);
		nations.add("GB");
		System.out.println(nations);

	}

}

//output :
/*
 * [IT, FR, GB, USA] -> same order as insertion 5
[IT, FR, USA] ->same order even when doing removal
[IT, FR, USA, GB] ->insertion is done at the end

 */

/*
 The output from line 5 confirms
that its access order matches the order in which the elements were inserted. The output from line 9 shows
that the add() method inserts at the end of the linked list.
 */

/*
	 The LinkedHashSet class is the same as the HashSet class, except that it maintains a doubly
	linked list of the elements in the order in which they are inserted. This overcomes the random
	ordering of the HashSet class. The only disadvantage is slightly slower insertion and deletion
	times, which in most cases would be unnoticeable.
 */