import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class Ring<E> extends AbstractList<E> implements List<E> {

	int size;
	Node<E> end;
	
	@Override
	public E get(int index) {
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<E> parser = end;
		for(int i=0;i<index;i++) {
			parser = parser.next;
		}
		return parser.element;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean add(E element) {
		if(size == 0) {
			end = new Node<E>(element,null);
			end.next = end;
		}else {
			end = end.next = new Node<E>(element,end.next);
		}
		size++;
		return true;
	}
	
	@Override
	public String toString() {
		Node<E> p = end.next;
		StringBuilder str = new StringBuilder("["+p.element);
		while(p!=end) {
			p=p.next;
			str.append(", "+p.element);
		}
		str.append("]");
		return str.toString();
	}
	@Override
	public Iterator<E> iterator(){
		return new RingIterator();
	}
	
	class RingIterator implements Iterator<E>{
		Node<E> preLast = end;
		Node<E> last;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size>0;
		}

		@Override
		public E next() {
			if( last == null) {
				last = preLast.next;
			}else {
				preLast = last;
				last = last.next;
			}
			return last.element;
		}
		
		@Override
		public void remove() {
			if(last == null)
				throw new IllegalStateException();
			if(size == 1) {
				end = preLast = null;
			}else {
				preLast.next = last.next;
			}
			if(last == end) {
				end=preLast;
			}
			last = null;
			size--;
		}
		
	}
	
	class Node<E> {
		Node<E> next ;
		E element;
		
		Node(E element, Node<E> next){
			this.next = next;
			this.element = element;
		}
	}
}
