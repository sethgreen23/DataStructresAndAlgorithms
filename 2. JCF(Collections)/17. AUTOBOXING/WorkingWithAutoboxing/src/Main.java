import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, 22,33,44,55,66);
		System.out.println(numbers);
		System.out.printf("Size: %d%n",numbers.size());
		System.out.printf("get(2): %d%n",numbers.get(2));
		int n = numbers.get(2);
		System.out.printf("Removed n: %s%n",numbers.remove(2));
		System.out.println(numbers);
		Integer removed = Integer.valueOf(66);
		numbers.remove(removed);
		System.out.printf("Removed n: %d%n",removed);
		System.out.println(numbers);
		
	}

}
//output
/*
	[22, 33, 44, 55, 66]
	Size: 5
	get(2): 44
	Removed n: 44
	[22, 33, 55, 66]
	Removed n: 66
	[22, 33, 55]
 */

/*
	*Java 5.0 introduced autoboxing, which means that a primitive value can be added to a collection without explicitly “wrapping” it in an object; it will be wrapped, or “boxed” automatically. It
	will also be unwrapped when extracted. This is illustrated in Example 4.16.

	*At line 6, the addAll() method from the Collections class inserts five Integer objects into list.
	The primitive int values, 22, 33, 44, 55, and 66 are “boxed” automatically, instantiating the five wrapper
	objects to hold them.
	At line 10, the element at index 2, which is the Integer object that holds the primitive int value 44, is
	accessed by the get() method. It is automatically “unboxed” during its assignment to the int variable n.
	The remove() method is overloaded in the JCF: One version takes an int argument that specifies the
	position of the element to be removed, and one version takes a reference to an object that equals() the
	element to be removed. These two versions are invoked at lines 12 and 15. At line 12, the element at index
	2, which is the object that holds 44, is removed. At line 15, the element that equals() the object that
	holds 66 is removed.
	Note that this would not work:
	list.remove(22); // ERROR: the argument refers to index 22
	Autoboxing occurs only when the types would otherwise be mismatched.
	Autoboxing, which might better be called “autowrapping,” also works in other contexts where
	an explicit instantiation of a wrapper class would otherwise be required. For example:
	Double pi = 3.14159; // OK
	Note that automatic implicit instantiation (also called promotion) also occurs when a primitive
	expression is combined with a String object by means of the concatenation operator +. For
	example:
	System.out.println("circumference = " + 2*pi*r); // OK
	In this case, the value of the double expression 2*pi*r is automatically wrapped in a new
	Double object, whose toString() method is then invoked to produce the String object that is
	concatenated with the String literal "circumference = ". This suggests that the alternative,
	System.out.printf("circumference = %f%n", 2*pi*r); // BETTER
	should be preferred.
 */
