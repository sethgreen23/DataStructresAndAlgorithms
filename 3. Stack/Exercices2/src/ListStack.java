import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ListStack<E> implements Stack<E> {
	private Node<E> head;
	int size=0;
	@Override
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		Node<E> removed = head;
		head = head.next;
		head.prev=null;
		size--;
		return removed.data;
	}

	@Override
	public E peek() {
		return head.data;
	}

	@Override
	public void push(E element) {
		Node<E> newNode;
		if(isEmpty()) {
			newNode = new Node<E>(element);
		}else {
			newNode = new Node<E>(element,head,head.prev);
			head.prev=newNode;
		}
		
		head = newNode;
		size++;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	
	public void print() {
		Node<E> parser = head;
		System.out.printf("Top: %s => ",parser.data);
		parser = parser.next;
		while(parser!=null) {
			System.out.printf("%s%s", parser.data,parser.next==null?"\n":" => ");
			parser = parser.next;
		}
	}
	static class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		Node(E data, Node<E> next, Node<E> prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		Node(E data){
			this.data = data;
		}
	}
	
//	5.16 Add this member method to the LinkedStack class shown in Example 5.4 on page 106:
//		public void reverse()
//		// reverses the contents of this stack

	
	public void reverse() {
		Node<E> parser = head;
		for(int i =0;i<size;i++) {
			Node<E> q= parser.next;
			parser.next=parser.prev;
			//chose the last element as head
			if(i==size-1)
				head = parser;
			parser=parser.prev=q;
			
		}
	}
	
//	5.18 Add this member method to the LinkedStack class shown in Example 5.4 on page 106:
//		public E penultimate()
//		// returns the second from the top element of this stack
	
	public E penultimate() {
		if(size<2)
			throw new NoSuchElementException();
		return head.next.data;
	}
	
//	5.20 Add this member method to the LinkedStack class shown in Example 5.4 on page 106:
//		public E popPenultimate()
//		// removes and returns the second element of this stack
	public E popPenultimate() {
		if(size<2)
			throw new NoSuchElementException();
		Node<E> remove = head.next;
		remove.prev.next=remove.next;
		remove.next.prev=remove.prev;
		remove.next=null;
		remove.prev=null;
		return remove.data;
		
	}
	
//	5.22 Add this member method to the LinkedStack class shown in Example 5.4 on page 106:
//		public E bottom()
//		// returns the bottom element of this stack
	public E bottom() {
		Node<E> parser = head;
		while(parser.next!=null) {
			parser=parser.next;
		}
		return parser.data;
	}
	
//	5.24 Add this member method to the LinkedStack class shown in Example 5.4 on page 106:
//		public E popBottom()
//		// removes and returns the bottom element of this stack
	
	public E popBottom() {
		Node<E> bottom = head;
		while(bottom.next!=null) {
			bottom=bottom.next;
		}
		bottom.prev.next=null;
		return bottom.data;
	}
}
