import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
	private int front;
	private int back;
	private E[] elements;
	private final int INIT_CAPACITY=4;
	public ArrayQueue() {
		elements = (E[]) new Object[INIT_CAPACITY];
	}
	
	public ArrayQueue(int capacity) {
		elements = (E[]) new Object[capacity];
	}
	@Override
	public void add(E element) {
		if(size() == elements.length-1)
			resize();
		elements[back]=element;
		
		if(back<elements.length-1) {
			back++;
		}else {
			back=0;
		}
		
	}

	private void resize() {
		int size = size();
		int len = elements.length;
		
		Object[] temp = new Object[len*2];
		
		if(front <= back) {
			System.arraycopy(elements, front, temp, 0, size);
		}else {
			System.arraycopy(elements, front, temp, 0, len-front);
			System.arraycopy(elements, 0, temp, len-front, back);
		}
		
		elements = (E[]) temp;
		back = size;
		front = 0;
		
	}

	@Override
	public E element() {
		if(isEmpty())
			throw new EmptyStackException();
		
		return elements[front];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	@Override
	public E remove() {
		if(isEmpty())
			throw new EmptyStackException();
		E element = elements[front];
		elements[front] = null;
		front++;
		
		if(front==back)
			front = back = 0;
		
		if(front == elements.length)
			front = 0;
		return element;
	}

	@Override
	public int size() {
		if(front <= back) {
			return back - front;
		}else {
			return back - front + elements.length;
		}
	}

	public void print() {
		System.out.println(Arrays.toString(elements));
		if(front<= back) {
			for(int i=front;i<back;i++) {
				System.out.print(elements[i]+(i+1==back?"\n":" => "));
			}
		}else {
			for(int i=front;i<elements.length;i++) {
				System.out.print(elements[i]+" => ");
			}
			for(int i=0;i<back;i++) {
				System.out.print(elements[i]+(i+1==back?"\n":" => "));
			}
		}
		
	}
	
//	6.9 Add this member method to the ArrayQueue class shown in Example 6.3 on page 119:
//		public void reverse()
//		// reverses the contents of this queue
	public void reverse() {
		resize();
		int mid = size()/2;
		int size = size();
		for(int i=0;i<mid;i++) {
			swap(elements,i,size-i-1);
		}
	}
	
//	6.11 Add this member method to the ArrayQueue class shown in Example 6.3 on page 119:
//		public E second() {
//		// returns the second element of this queue
	public E second() {
		if(size()<2)
			throw new NoSuchElementException();
		if(front+1==elements.length)
			return elements[0];
		return elements[front+1];
	}
	
	
//	6.13 Add this member method to the ArrayQueue class shown in Example 6.3 on page 119:
//		public E removeSecond() {
//		// removes and returns the second element of this queue
		public E removeSecond() {
			if(size()<2)
				throw new NoSuchElementException();
			resize();
			int size = size();
			E element = elements[front+1];
			elements[front+1]=null;
			System.arraycopy(elements, front+2, elements, front+1, size-(front-2));
			back --;
			return element;
		}
		public E removeSecond1() {
			if(size()<2)
				throw new NoSuchElementException();
			int len = elements.length;
			E element=null ;
			if(front+1==len) {
				element = elements[0];
				E first = elements[front];
				elements[front]=null;
				elements[0]=first;
				front = 0;
			}else {
				element = elements[front+1];
				E first = elements[front];
				elements[front++]=null;
				elements[front]=first;
							
			}
			return element;
		}
		
	public void swap(E[] arr, int i, int j) {
		E temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}


}
