import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayStack<E> extends AbstractStack<E> {
	E[] stack;
	public final int CAPACITY = 100;
	public ArrayStack() {
		stack = (E[]) new Object[CAPACITY];
	}
	public ArrayStack(int initialSize) {
		stack = (E[]) new Object[initialSize];
	}
	@Override
	public E pop() {
		E element = stack[size-1];
		stack[--size]=null;
		return element;
	}
	@Override
	public E peek() {
		
		return stack[size-1];
	}
	@Override
	public void push(E element) {
		if(size==stack.length) {
			//resize the stack
			E[] newStack =(E[]) new Object[size*2];
			System.arraycopy(stack, 0, newStack, 0, size);
			stack = newStack;
		}
		
		stack[size++]=element;
		
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		System.out.printf("Top: %s => ", stack[size-1]);
		for(int i=size-2;i>=0;i--) {
			System.out.printf("%s %s",stack[i],i==0?"\n":"=> ");
		}
	}
	
//	5.15 Add this member method to the ArrayStack class shown in Example 5.3 on page 104:
//		public void reverse()
//		// reverses the contents of this stack
	public void reverse() {
//		E[] reversed = (E[]) new Object[size];
//		for(int i=size-1,j=0;i>=0;i--,j++) {
//			reversed[j]=stack[i];
//		}
//		System.arraycopy(reversed, 0, stack, 0, size);
		
		//another way
		for(int i=0;i<size/2;i++) {
			E temp = stack[i];
			stack[i]=stack[size-1-i];
			stack[size-1-i]=temp;
		}
	}
	
//	5.17 Add this member method to the ArrayStack class shown in Example 5.3 on page 104:
//		public E penultimate()
//		// returns the second from the top element of this stack
	
	public E penultimate() {
		if(size<2)
			throw new NoSuchElementException();
		return stack[size-2];
	}
	
//	5.19 Add this member method to the ArrayStack class shown in Example 5.3 on page 104:
//		public E popPenultimate()
//		// removes and returns the second element of this stack
	public E popPenultimate() {
		if(size<2)
			throw new NoSuchElementException();
		E first = stack[--size];
		stack[size]=null;
		E second = stack[--size];
		stack[size++]=first;
		return second;
	}
	
//	5.21 Add this member method to the ArrayStack class shown in Example 5.3 on page 104:
//		public E bottom()
//		// returns the bottom element of this stack
	public E bottom() {
		if(isEmpty()) 
			throw new EmptyStackException();
		return stack[0];
	}
	
//	5.23 Add this member method to the ArrayStack class shown in Example 5.3 on page 104:
//		public E popBottom()
//		// removes and returns the bottom element of this stack
	public E popBottom() {
		if(isEmpty())
			throw new EmptyStackException();
		E removedFirst = stack[0];
		System.arraycopy(stack, 1, stack, 0, size-1);
		stack[size-1]=null;
		size--;
		return removedFirst;
	}
}
