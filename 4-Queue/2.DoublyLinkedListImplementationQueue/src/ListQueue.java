import java.util.EmptyStackException;

public class ListQueue<E> extends AbstractListQueue<E> {
	Node<E> head = new Node<E>();//dummy node
	
	@Override
	public void add(E element) {
		//the previous will point to the last element of the node if we want to parse the queue from back to from we use the prev parser
		//the new node take the previous of head as previous and the previous of the head take the new node as next to it 
		//the new node take the header as next because it is null
		//we change the previous node of the head to the new node 
		//to keep track of the tail of the queue in case we wanted to parser it from back to front
		head.prev = head.prev.next = new Node<E>(element,head.prev,head);
		//increment the size
		size++;
	}

	@Override
	public E element() {
		if(isEmpty())
			throw new EmptyStackException();
		
		return head.next.element;
	}

	@Override
	public E remove() {
		if(isEmpty())
			throw new EmptyStackException();
		//save the data of the node we want to remove
		Node<E> removed = head.next;
		//the head next will be the one after the first node
		head.next = head.next.next;
		//the previous of the second node will be head
		head.next.prev = head;
		size--;
		//we can clean the linked of the removed node
		removed.next = null;
		removed.prev = null;
		return removed.element;
		
	}
	
	public void print() {
		Node<E> parser = head.next;
		while(parser!=head) {
			System.out.printf("%s%s", parser.element,parser.next!=head?" => ":"\n");
			parser = parser.next;
		}
		
	}

	static class Node<E>{
		
		Node<E> next;
		Node<E> prev;
		E element;
		
//		The constructor defined at line 41 constructs a dummy node with null
//		element and with both links pointing to the node itself.	
		Node(){
			this.next = this.prev = this;
		}
		
		Node(E element, Node<E> prev, Node<E> next){
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		
	}

}
