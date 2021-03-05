
public class Main {
	/*
	 * Instead of devising a more effective collision resolution algorithm, we can
	 * avoid collisions altogether by allowing more than one item per table
	 * component. This method is called separate chaining, because is uses linked
	 * lists (“chains”) to hold the multiple items. In this context, the table
	 * components are usually called “buckets.” EXAMPLE 8.8 Separate Chaining Here
	 * is how part of a definition for a HashTable class might look, using separate
	 * chaining: 
	 * 
	 * 
	 *
	 *
	public class HashTable {
		private static final int MASK = 0x7FFFFFFF; // 2^32-1
		private static int capacity = 101;
		private static int size = 0;
		private static float load = 0.75F;
		private static LinkedList[] buckets;

		HashTable() {
			buckets = new LinkedList[capacity];
			for (int i = 0; i < capacity; i++) {
				buckets[i] = new LinkedList();
			}
		}

		HashTable(int capacity, float load) {
			this();
			this.capacity = capacity;
			this.load = load;
		}

		Object put(Object key, Object value) {
			int h = hash(key);
			LinkedList bucket = buckets[h];
			Object oldValue = null;
			for (ListIterator it = bucket.iterator(); it.hasNext();) {
				Map.Entry entry = it.next();
				if (entry.getKey().equals(key)) {
					break;
				}
			}
			if (entry.getKey().equals(key)) {
				oldValue = entry.setValue(value);
			} else {
				bucket.add(new Entry(key, value));
			}
			return oldValue;
		}

		// more methods...
	}


 
	 * Note that put() serves two different purposes. If the table already
	 * has an entry with the given key, it only changes the value of that entry.
	 * Otherwise, it adds a new entry with that key/value pair. The
	 * java.util.HashMap class uses separate chaining in a way that is similar to
	 * that shown in Example 8.8.
	 * 
	 */
	}