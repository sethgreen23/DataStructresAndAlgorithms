
public abstract class AbstractStack<E> implements Stack<E> {
	protected int size=0;
	
	public abstract void push(E e);

	
	public abstract E peek();

	
	public abstract E pop();

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}



}

/*
The ArrayStack and LinkedStack implementations of the Stack interface are quite different. 
Nevertheless, they do have some identical code. The size() method and the isEmpty()
method are the same. Their implementation does not depend upon whether the backing structure
is indexed or linked.
When parts of an implementation are independent of the underlying data structure, 
it is advantageous to implement those parts separately in an abstract class.
 */

/*
The three methods that depend upon the implementation’s backing structure are declared abstract
(lines 8, 10, and 12). This of course requires the class itself to be declared abstract.
Notice at line 2 that the size field is declared protected instead of private so that it can be accessed
by the extending concrete classes.
With the AbstractStack class implemented as shown in Example 5.5, we can now simplify
the two concrete implementations from Example 5.3 on page 104 and Example 5.4 on page 106.
We need only add the expression extends AbstractStack<E> to each class header, and then we
can remove their isEmpty() and size() methods and their declaration of the size field. This of
course is the strategy used by the JCF. (See Figure 4.1 on page 70.)
*/