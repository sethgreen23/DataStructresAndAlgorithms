import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack{
	private E[] stack;
	int top = 0;
	public ArrayStack(int capacity) {
		stack = (E[]) new Object[capacity];
		
	}
	@Override
	public E peek() {
		if(isEmpty()) 
			throw new EmptyStackException();
		return stack[top-1];
	}
	
	@Override
	public void push(Object e) {
		if(top == stack.length)
			resize();
		stack[top++]=(E)e;
	}

	private void resize() {
		E[] newArray =(E[]) new Object[stack.length * 2];
		System.arraycopy(stack, 0, newArray, 0, stack.length);
		stack = newArray;
	}
	@Override
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		E removedElement = stack[--top];
		stack[top]=null;
		return removedElement;
	}

	@Override
	public boolean isEmpty() {
		return top==0;
	}

	@Override
	public int size() {
		return top;
	}
	@Override
	public void print() {
		int parser=top-1;
		while(parser>=0) {
			System.out.printf("%s %s",stack[parser--],(parser<0?"\n":" => "));
		}
		
	}
	
}

