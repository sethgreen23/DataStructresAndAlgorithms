import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack{
	
	Node<E> head;
	int size =0;

	@Override
	public void push(Object e) {
		Node<E> node = new Node<E>((E)e,head);
		head = node;
		size++;
		
	}


	@Override
	public E peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return head.data;
	}



	@Override
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		Node<E> removedElement = head;
		head = head.next;
		removedElement.next = null;
		size--;
		return removedElement.data;
	}



	@Override
	public int size() {
		return size;		
	}



	@Override
	public boolean isEmpty() {
		return size==0;
		
	}



	@Override
	public void print() {
		if(isEmpty()) {
			System.out.println("The Stack is Empty!!");
			return ;
		}
		
		
		Node<E> parser = head;
		while(parser!=null) {
			System.out.printf("%s%s",parser.data,parser.next!=null?" => ":"");
			parser = parser.next;
		}
		System.out.println();
	}
	
	
	
	
	static class Node<E>{
		
		E data;
		Node<E> next;
		
		Node (E data,Node<E> next){
			this.next = next;
			this.data = data;
		}
		Node (E data){
			this.data =data;
		}
	}
}
