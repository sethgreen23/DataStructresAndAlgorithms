import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//testing print function
		List<String> nations = new ArrayList<String>();
		Collections.addAll(nations, "Germany","France","Italie","Germany","Germany","China","Hungary","Tunisia","USA");
		System.out.println(chars(nations));
		print(nations);
		System.out.println("***********");
		//testing generic method frequency
		List<Integer> numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, 1,1,2,1,3,4,5,7,1,4,8,8,1,9);
		System.out.println(numbers);
		System.out.println("Frequency of 1 in numbers: "+frequency(numbers,1));
		System.out.println(nations);
		System.out.println("Frequency of Geramany in nations: "+frequency(nations,"Germany"));
		System.out.println("***********");
		//testing the getLast method
		System.out.printf("getLast: %s%n",getLast(nations));
		System.out.printf("getLast: %s%n",getLast(numbers));
		System.out.println("***********");
		//testing getElement
		System.out.println(nations);
		System.out.printf("getElement at position 5 : %s%n",getElementAt(nations,5));
		System.out.println(numbers);
		System.out.printf("getElement at position 11 : %s%n",getElementAt(numbers,11));
		System.out.println("***********");
		Integer[] input = {1,2,3,4,5,6,7,8,9};
//		List<Integer> list =(List<Integer>) toCollection(input);
//		System.out.println(list);
		Collection<Integer> list = toCollection(input);
		System.out.println(list);
	}
/*	
	Write and test this client method:
		<E> Collection<E> toCollection(E[] a)
		// returns a generic Collection that contains the elements
		// of the specified array
*/	
	//using asList method of Arrays class
//	static <E> Collection<E> toCollection(E[] a){
//		return Arrays.asList(a);
//	}
	
	static <E> Collection<E> toCollection(E[] a){
		Collection<E> c = new ArrayList<E>();
		for(E e : a) {
			c.add(e);
		}
		return c;
	}
	
/*
	Write and test this generic method:
		<E> E getElementAt(List<E> list, int index) {
		// returns the list element at the specified index
		a. using an iterator.
		b. using an enhanced for loop
*/
	//using iterator
//	static <E> E getElementAt(List<E> list, int index) {
//		int parser = 0;
//		E result = null;
//		for(Iterator<E> iterator = list.iterator();iterator.hasNext();) {
//			result = iterator.next();
//			if(index == parser++) {
//				break;
//			}
//		}
//		return result;
//	}
	static <E> E getElementAt(List<E> list, int index) {
		E result = null;
		for(int i=0;i<list.size();i++) {
			result = list.get(i);
			if(i==index)
				break;
		}
		return result;
	}
/*	
	Write and test this generic method:
		<E> E getLast(List<E> list) {
		// returns the last element of the list
		a. using an iterator.
		b. using an enhanced for loop
*/
	//using iterator
//	static <E> E getLast(List<E> list) {
//		if(list.isEmpty())
//			return null;
//		Iterator<E> iterator = list.iterator();
//		E result=null;
//		do{
//			if(!iterator.hasNext())
//				break;
//			result = iterator.next();
//		}while(iterator.hasNext());
//		
//		return result;		
//	}
	//using loop
	static <E> E getLast(List<E> list) {
		if(list.isEmpty())
			return null;
		E result = null;
		for(E element : list) {
			result = element;
		}
		return result;
	}
	
	
/*	
	Write and test this generic method:
		<E> int frequency(Collection<E> c, E e) {
		// returns the number of occurrences of e in c
		a. using an iterator.
		b. using an enhanced for loop.
*/
	static <E> int frequency(Collection<E> c,E e) {
		int sum =0;
		//using loop
//		for(E element : c) {
//			if(element.equals(e))
//				sum++;
//		}
		//using iterator
		for(Iterator<E> iterator = c.iterator();iterator.hasNext();) {
			if(iterator.next().equals(e))
				sum++;
		}
		
		return sum;
	}
	
/*
	 Write and test this method, using an iterator:
		void print(Collection c)
		// prints all the elements of the collection c
		Note that this has the same effect as in Example 4.4 on page 76.
 */
	static void print(Collection c) {
		System.out.print("{");
		for(Iterator iterator=c.iterator();iterator.hasNext();) {
			System.out.printf("\"%s\"", iterator.next());
			System.out.print(iterator.hasNext()?", ":"}\n");
		}
	}
	
/*
	Write and test this method:
		int chars(List<String> strings)
		// returns the total number of characters in all the strings
*/
	static int chars(List<String> strings) {
		int sum=0;
		//using loop
//		for(String str : strings) {
//			sum+=str.length();
//		}
		//using iterator
		for(Iterator<String> iterator=strings.iterator();iterator.hasNext();)
			sum+=iterator.next().length();
		return sum;
	}
}
