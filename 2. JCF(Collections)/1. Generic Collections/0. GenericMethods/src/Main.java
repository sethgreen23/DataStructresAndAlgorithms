import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main (String[] args) {
		String[] nations = new String[] {"JP","GB","FR","RUS","USA"};
		print(nations);
	}
	
	static <E> void print(E[] arr) {
		for(E e : arr) {
			System.out.printf("%s, ", e);
		}
	}
}

/*
output 
JP, GB, FR, RUS, USA, 
*/

/*
 The method is identified as generic by the <E> specifier at line 7. This allows the type parameter E to be
used in place of an actual type in the method block at line 11.
 */