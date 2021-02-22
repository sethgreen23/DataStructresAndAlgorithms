import java.util.Arrays;
import java.util.EmptyStackException;


public class ArrayQueue<E> implements Queue<E> {
	int front;
	int back;
	E[] elements;
	private final int INIT_CAPACITY=4;
	
	//create the queue with standard capacity
	public ArrayQueue() {
		elements = (E[]) new Object[INIT_CAPACITY];
	}
	//give your own initial capacity
	public ArrayQueue(int capacity) {
		elements = (E[]) new Object[capacity];
	}
	@Override
	public void add(E element) {
		//we need to have two empty indexes in the array to hold the current insertion and the next index we will insert into
		//if not we have just one empty space then what will happens we will insert the current element and back will
		//move with one step and this step will be the first element in the queue and this wrong then we need to resize
		if(size()==elements.length-1)
			resize();
		//insert the element in its back position
		elements[back]=element;
		
		//if back is less then the last index inthe array then we increment by one to be the next position
		if(back<elements.length-1) {
			back++;
		}else {//else if back is on the last position in the array(length-1) then we wrap the next position of insertion on the front of the array (position 0)
			//while we have two free positions in the array
			back = 0;
		}
	}

	private void resize() {
		//we save the size of the queue we will need it and the length of the array before resize we need it too
		int size = size();
		int len = elements.length;
		// we create temporary array to hold the new elements of the array
		Object[] temporary = new Object[len*2];
		System.out.println(Arrays.toString(elements)+" / front "+front+" / back "+back+" / size "+size+" / len "+len);
		//if the back didnt wrapp the we just copy the elements in there normal positions from front to back  
		//we start by from front position and we finish to back and we copy back - front positions
		if(front<=back) {
			System.arraycopy(elements, front, temporary, 0, back-front);
		}else {
			//if the back wrap to the begging of the array the we need to copy the array in two parts
			//first part will be from front till the end of the array starting and copying length - front positions
			System.arraycopy(elements, front, temporary, 0, len-front);
			//in the second part we will copy back positions from the length - front positions
			System.arraycopy(elements, 0, temporary, len-front, back);
		}
				
		elements = (E[]) temporary;
		System.out.println(Arrays.toString(temporary));
		front = 0;
		back = size;
	}
	
	@Override
	public E element() {
		//it the size ==0 then the queue is empty
		if(size()==0) {
			throw new EmptyStackException();
		}
		//return the first element of the queue
		return elements[front] ;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public E remove() {
		//if the size==0 the the queue is empty
		if(size()==0)
			throw new EmptyStackException();
		//save the first element that we will remove
		E removeElement = elements[front];
		//mark the first element as null
		elements[front] = null;
		//the next position will be the first position
		front++;
		//if the front == back then the queue is empty the we assign the first and back position to zero
		if(front==back) {
			front = back = 0;
		}
		//if the front equals the length of the array then we wrap it to the first position while we have two free position in the array
		if(front == elements.length)
			front = 0;
		return removeElement;
	}

	@Override
	public int size() {
		//if we didnt have back or front not wrapped on the begging of the array then we do back -front because back is infront of front
		if(front <= back) {
			return back -  front;
		}else {//else we will have back wrapped to the first positions before front then we do back -front + length of the array
			return back - front + elements.length;
		}
	}
	
	public void print() {
		if(size()==0) {
			System.out.println("Queue is empty!");
			return;
		}
			
		for(int i=0;i<elements.length;i++) {
			E str = elements[i];
			System.out.printf("%s => %s", str,i==elements.length-1?"\n":"");
		}
	}

}