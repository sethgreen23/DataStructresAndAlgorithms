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

/*
	4.1 The Java Collections Framework is a group of interrelated interfaces and classes that support the creation and use of lists, sets, and iterators.
	4.2 The four main types are List, Queue, Set, and Map.
	4.3 A queue is a first-in-first-out collection that allows elements to be added at only one end (the back) and removed only from the other end (the front).
	4.4 A deque is a double-ended queue that allows elements to be added and removed only from its two ends (the front and back).
	4.5 A legacy class is a class that has been superseded by another class
	4.6 The ArrayList, ArrayDeque, ArrayDeque, and HashMap classes are implemented with an array.
	4.7 The LinkedList, PriorityQueue, TreeSet, and TreeMap classes are implemented with a linked structure (either a linked list or a tree).
	4.8 The LinkedHashSet class and the LinkedHashMap class are implemented with a linked indexed structure.
	4.9 An ArrayList object is an instance of the java.util.ArrayList class. As a member of the Java Collections Framework, 
		it supports all the methods of the Collection interface. As an indexed structure, it provides direct access to its elements by their index numbers.
	4.10 A LinkedList object is an instance of the java.util.LinkedList class. As a member of the Java Collections Framework, it supports all the methods of the Collection interface. As a linked
		structure, it allows elements to be added and removed in constant time, independent of the size of the
		list.
	4.11 The Collection interface is a Java interface that specifies the 15 methods listed in Figure 4.2 on
		page 71.
	4.12 The four set-theoretic methods specified by the Collection interface are listed in Figure 4.2 on page
		71: addAll() for unions, removeAll() for complements, retainAll() for intersections, and
		containsAll() for testing the subset relation.
	4.13 An iterator is an object that moves about on a collection, providing access to its elements.
	4.14 An iterator can be used to traverse a collection with a for loop, in the same way that an index can be
		used to traverse an array.
	4.15 An array index provides direct access (i.e., random access) into an array. An iterator provides only
		sequential access.
	4.16 The java.util.Arrays class includes an asList() method that returns a List object whose elements are the same as those in the array passed to it. (See Example 4.15 on page 96.)
	4.17 The java.util.Collections class includes an addAll() method that adds all elements that are
		passed to it. (See Example 4.15 on page 96.) The method takes a variable number of arguments (i.e., it
		is a varargs method).
	4.18 A generic class is a class that uses generic type parameters, that is, parametrized types. (See page 96.)
	4.19 A generic method is a method that uses generic type parameters, that is, parametrized types.
	4.20 A generic type parameter is a symbol used in a class or method definition that represents a type. When
		applied, an actual class or interface name must be substituted for the parameter.
	4.21 A constrained generic type parameter is a generic type parameter that is constrained by an extends
		clause.
	4.22 A generic type argument is a class or interface name that is being substituted for a generic type parameter in a generic class or generic method.
	4.23 The term “autoboxing” refers to the automatic implicit instantiation of a wrapper class thereby allowing the value of a fundamental type expression to be used where an object is expected, for example, in
		the Collections.addAll() method. (See Example 4.16 on page 97.)
 */
