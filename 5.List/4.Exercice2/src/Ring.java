import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class Ring<E> extends AbstractList<E> implements List<E> {

	private Node<E> end;
	private int size;
	@Override
	public E get(int index) {
		if(size==0)
			throw new IllegalArgumentException();
		Node<E> parser = end;
		for(int i=0;i<index;i++)
			parser = parser.next;
		return parser.element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean add(E element) {
		if(end == null) {
			end = new Node<E>(element,null);
			end.next = end;
		}else {
			end = end.next = new Node<E>(element,end.next);
		}
		size++;
		return true;
	}
	
	@Override
	public Iterator<E> iterator(){
		return new RingIterator();
	}
	
	public void print() {
		Node<E> parser = end.next;
		int length = size();
		while(--length>=0) {
			System.out.printf("%s => ",parser.element);
			parser = parser.next;
		}
		System.out.println();
	}
	class RingIterator implements Iterator<E>{
		Node<E> preLast = end;
		Node<E> last;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size()>0;
		}

		@Override
		public E next() {
			if(last == null) {
				last = preLast.next;
			}else {
				preLast = last;
				last = last.next;
			}
			return last.element;
		}
		
		@Override
		public void remove() {
			if(size==1) {
				preLast = last = null;
			}else {
				preLast.next = last.next;
			}
			if(last == end) {
				end = preLast;
			}
			last = null;
			size--;
		}
	}
	
	static class Node<E>{
		Node<E> next;
		E element;
		Node(E element, Node<E> next){
			this.element = element;
			this.next = next;
		}
	}
	
//	7.5 Modify the solution to the Josephus Problem (Example 7.6 on page 140) so that it also uses a
//	SKIP parameter to generate the output. The value of SKIP is a constant nonnegative integer
//	that specifies whom each soldier should kill. For example, if skip = 2, then A would kill D
//	(skipping over B and C), E would kill H, and so forth. The original solution is then the special case where skip = 0. Assume that no one commits suicide. So if a killer’s target turns
//	out to be himself, he would kill the next man in the list.
	
	
	public static void main(String[] args) {
		Ring<String> ring = new Ring<String>();
		ring.add("A");
		ring.add("B");
		ring.add("C");
		ring.add("D");
//		ring.add("F");
//		ring.add("G");
//		ring.add("H");
//		ring.add("I");
//		ring.add("J");
		Iterator<String> iterator = ring.iterator();
		int skip = 2,i=skip;
		String killer = iterator.next();
		String victime = null;
		while(ring.size()>1 && --i>=0) {
			victime=iterator.next();
			if(i==0) {
				if(killer==victime) {
					victime=iterator.next();
					iterator.remove();
					killer = iterator.next();
				}else {
					iterator.remove();
					killer = iterator.next();
				}
				i=skip;
			}
		}
			
//			while(ring.size()>1 && --i>=0) {
//				victime=iterator.next();
//				if(i==0) {
//					if(killer==victime) {
//						victime=iterator.next();
//						iterator.remove();
//						killer = iterator.next();
//					}else {
//						iterator.remove();
//						killer = iterator.next();
//					}
//					i=skip;
//				}
//			}
			System.out.println("Survivor : "+killer);
			
	}
}
