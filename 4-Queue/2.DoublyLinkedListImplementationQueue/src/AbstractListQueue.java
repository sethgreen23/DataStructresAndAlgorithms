
public abstract class AbstractListQueue<E> implements Queue<E> {
	int size;
	
	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	
	@Override
	public int size() {
		return size;
	}

}
