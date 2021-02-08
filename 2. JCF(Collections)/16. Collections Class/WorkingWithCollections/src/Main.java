import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> g8 = new ArrayList<String>();
		Collections.addAll(g8, "FR","GER","IT","GB","JP","USA","RUS");
		System.out.println(g8);
		Collections.swap(g8, 2, 4);
		System.out.println("Swapped 2 with 4: "+g8);
		Collections.sort(g8);
		System.out.println("Sorted: "+g8);
		int k = Collections.binarySearch(g8, "CN");
		if(k<0) {
			g8.add(-k-1, "CN");
		}
		System.out.println("Position for insertion of \"CN\": "+(Math.abs(k)-1));
		System.out.println("Add \"CN\" into the list: "+g8);
	}

}
//output 
/*
	[FR, GER, IT, GB, JP, USA, RUS]
	Swapped 2 with 4: [FR, GER, JP, GB, IT, USA, RUS]
	Sorted: [FR, GB, GER, IT, JP, RUS, USA]
	Position for insertion of "CN": 0
	Add "CN" into the list: [CN, FR, GB, GER, IT, JP, RUS, USA]
 */

/*
	The java.util.Collections class provides over 50 static utility methods that implement
	algorithms for sorting, searching, shuffling, and maintaining collections, among other tasks
 */

/*
	At line 4, the addAll() method is used to load eight strings into the empty list g8. At line 6, the "JP"
	and "GB" elements are swapped, and then the list is sorted at line 8.
	At line 10, the binarySearch() method searches for the string "CN". The negative output signals that
	it is not there. The value of k tells where to insert it to keep the list sorted: at index –k – 1.
	Finally, at line 16, the reverse() method reverses the entire list.
*/
