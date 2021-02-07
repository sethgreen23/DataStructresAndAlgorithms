
public class Main {

	/*
	 *List interface
	A list is a linearly ordered data structure in which every element (except possibly the first) has
	a predecessor element and every element (except possibly the last) has a successor element. List
	elements are usually numbered in sequence: x0, x1, x2, . . . The numbers are called indexes or
	subscripts. Unlike sets, list data structures usually allow duplicate elements.
	The List interface extends the Collection interface. (See Figure 4.1 on page 70.) In
	addition to the 15 methods specified by the Collection interface (Figure 4.2 on page 71), the
	List interface also specifies these 10 additional methods:
	
	voidadd(int index, E element)
	boolean addAll(int index, Collection<? extends E> c)
	E get(int index)
	int indexOf(Object o)
	int lastIndexOf(Object o)
	ListIterator<E> listIterator()
	ListIterator<E> listIterator(int index)
	E remove(int index)
	E set(int index, E element)
	List<E> subList(int fromIndex, int toIndex)
	
	These methods use indexed access into the list.
	The indexed addAll() method has a second parameter with this generic type:
	Collection<? extends E>
	The ? symbol, called a generic wildcard, means that the type is unknown. The expression
	? extends E means the unknown type must be an extension of the collection’s element type E.
	The ListIterator<E> type is outlined on page 87.
 */
	
	
}
