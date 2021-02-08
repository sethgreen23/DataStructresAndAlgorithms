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
