import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ListQueue<E> extends AbstractListQueue<E> {
	Node<E> head ;
	
	public ListQueue() {
		head = new Node<E>();
	}
	
	@Override
	public void add(E element) {
		 head.prev=head.prev.next= new Node<E>(element,head.prev,head);
		 size++;
	}

	@Override
	public E element() {
		if(isEmpty()){
			System.out.println("Nothing to print the queue is empty.");
			return null;
		}
		return head.next.element;
	}

	@Override
	public E remove() {
		if(isEmpty()) {
			System.out.println("Nothing to remove the queue is empty.");
			return null;
		}
		E element = head.next.element;
		head.next = head.next.next;
		head.next.prev = head;
		size--;
		return element;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Nothing to print the queue is empty.");
			return ;
		}
		Node<E> parse = head.next;
		System.out.print("[");
		if(parse.element!=null) {
			System.out.print(parse.element);
		}
		parse = parse.next;
		while(parse!=head) {
			System.out.print(", "+parse.element);
			parse=parse.next;
		}
		System.out.println("]");
	}
	
//	6.10 Add this member method to the LinkedQueue class shown in Example 6.4 on page 120:
//		public void reverse()
//		// reverses the contents of this queue
	
	public void reverse() {
		Node<E> p = head;
		int size = size();
		for(int i=0;i<=size;i++) {
			Node<E> q = p.next;
			p.next = p.prev;
			p = p.prev = q;
		}
	}
	
//	6.12 Add this member method to the LinkedQueue class shown in Example 6.4 on page 120:
//		public E second() {
//		// returns the second element of this queue
	public E second() {
		if(size<2)
			throw new NoSuchElementException();
		return head.next.next.element;
	}
	
//	6.14 Add this member method to the LinkedQueue class shown in Example 6.4 on page 120:
//		public E removeSecond() {
//		// removes and returns the second element of this queue
	
	public E removeSecond() {
		E element = head.next.next.element;
		head.next.next =head.next.next.next;
		head.next.next.prev=head.next;
		size--;
		return element;
	}
		
		
	static class Node<E>{
		Node<E> next;
		Node<E> prev;
		E element;
		
		Node(E element, Node<E> prev, Node<E> next){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		Node(){
			 this.next = this.prev = this;
		}
	}
}
