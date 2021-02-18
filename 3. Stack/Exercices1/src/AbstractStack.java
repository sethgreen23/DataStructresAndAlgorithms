
public abstract class AbstractStack<E> implements Stack<E> {
	
	int size = 0;
	@Override
	public boolean isEmpty() {
		return size==0;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
}
