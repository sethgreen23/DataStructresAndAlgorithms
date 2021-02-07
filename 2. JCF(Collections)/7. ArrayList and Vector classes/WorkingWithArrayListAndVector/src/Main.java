
public class Main {

	/*
	The ArrayList class uses an array to implement the List interface. When the array becomes
	full, the add() method resizes it by replacing it with one that is twice as big. That is timeconsuming, but it happens infrequently.
	The array index allows the get() and set() methods to run in constant time, independent of
	the size of the collection. Also, the no-argument add() method runs in amortized constant time,
	which means that the time it takes to insert n elements is (on average) proportional to n. It does
	so by appending the new elements to the end of the list.
	The indexed add() and remove() methods have to shift subsequences of elements back and
	forth in the array to accommodate the inserted elements and to fill the gaps left by the deleted
	elements. Consequently, these operations run in linear time, which means that the time is (on
	average) proportional to the size of the collection.
	The Vector class is similar to the ArrayList class, using a resizable array to store its
	elements. It has 45 methods, including the 3 that it inherits from the AbstractList class. In
	addition to those 3, the 15 methods specified by the Collection interface (Figure 4.2 on page
	71), and the 10 methods specified by the List interface, it implements these 17 Vector
	methods:
	void addElement(E obj)
	int capacity()
	void copyInto(Object[] anArray)
	E elementAt(int index)
	Enumeration<E> elements()
	void ensureCapacity(int minCapacity)
	E firstElement()
	int indexOf(Object o, int index)
	void insertElementAt(E obj, int index)
	E lastElement()
	int lastIndexOf(Object o, int index)
	void removeAllElements()
	boolean removeElement(Object obj)
	void removeElementAt(int index)
	void setElementAt(E obj, int index)
	void setSize(int newSize)
	void trimToSize()
	These date back to Java 1.0, which preceded the JCF. Most of them are redundant. For example,
	the removeElement(Object) method is the same as the remove(Object) method specified by
	the Collection interface, and the removeElementAt(int) method is the same as the
	remove(int) method specified by the List interface.
	 * */
}
