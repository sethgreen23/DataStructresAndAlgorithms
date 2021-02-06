import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> nations = new HashSet<String>();
		//Set<Integer> nations = new HashSet<Integer>();
		Collections.addAll(nations, "FR","GB","USA","RUS");
		//Collections.addAll(nations, 1,2,3,4);
		print(nations);
	}
	
	static void print(Collection<?> c) {
		for(Object o : c) {
			//System.out.print(o+", ");
			System.out.printf("%s, ",o);
		}
		System.out.println();
	}
}

/*
output with integer
1, 2, 3, 4,
output with strings
RUS, USA, GB, FR, 
*/