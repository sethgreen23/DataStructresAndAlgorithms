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
/*
 This method can be used to print any type of collection, for example, a HashSet<String> or a
Queue<Date>.
Note that if we used Collection<Object> instead of Collection<?> at line 1, then the method
would only apply to collections whose element type is specified as Object. For example, it could not be
used to print a HashSet<String> because that is not an extension of Collection<Object>.


if you wanted to restrict the print() method in Example 4.5 to extensions of a Person class, then you would replace line 1 with:
1 static void print(Collection<? extends Person> c) {
The expression ? extends Person is called a bounded wildcard type.
 */