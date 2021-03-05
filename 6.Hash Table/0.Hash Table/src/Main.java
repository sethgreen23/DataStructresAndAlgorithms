
public class Main {
	/*
	 * The order in which the key/value pairs were stored in the HashMap object in
	 * Example 8.1 seems to be random and unrelated to the order in which the pairs
	 * were inserted. The next example verifies this.
	 * 
	 * map1={Rad=wheel, Uhr=clock, Ohr=ear, Tor=gate, Hut=hat, Tag=day}
	 * map2={Rad=wheel, Uhr=clock, Ohr=ear, Tor=gate, Hut=hat, Tag=day} The order in
	 * which the key/value pairs are stored in the HashMap table is reflected by the
	 * output from the toString() method. That stored order is same in both tables,
	 * independent of the order in which they were inserted. Note that it is also
	 * the same stored order in the HashMap table in Example 8.1.
	 * 
	 * 
	 * The order in which the key/value pairs are stored in a HashMap table depends
	 * only upon the capacity of the table and the values of objects’ the hash
	 * codes. Recall (Chapter 4) that every object in Java is given an intrinsic
	 * hash code, which is computed from the actual hard data stored in the object.
	 * The Object.hashCode() method returns that code for each object. EXAMPLE 8.3
	 * Hash Codes of Some String Objects This program prints the intrinsic hash
	 * codes of the String objects stored in the previous programs:
	 
	public class TestHashCodes {
		public static void main(String[] args) {
			printHashCode("Rad");
			printHashCode("Uhr");
			printHashCode("Ohr");
			printHashCode("Tor");
			printHashCode("Hut");
			printHashCode("Tag");

		}

		private static void printHashCode(String word) {
			System.out.printf("%s: %s%n", word, word.hashCode());
		}
	}
	
	 * The output is: Rad: 81909 Uhr: 85023 Ohr: 79257 Tor: 84279 Hut: 72935 Tag:
	 * 83834 The fact that all six codes are relatively close 5-digits integers
	 * reflects the fact that these String objects all have length 3.
	 * 
	 * The result is that the items are stored in reverse order from which they are
	 * accessed
	 * 
	 * The solution to the problem described here is to prevent the hash table from
	 * becoming too full. This is done by resizing it whenever it reaches a
	 * threshold size. The measure of fullness depends upon two parameters: The size
	 * of the hash table is the actual number of elements in the table; the capacity
	 * of the table is the number of components that it has. The ratio of these two
	 * parameters is called the load factor. In the first example cited in this
	 * section, the size was 6 and the capacity was 101, resulting in a load factor
	 * of 6/101 = 5.94 percent. In the second example, the size was 100, resulting
	 * in a load factor of 100/101 = 99.01 percent. The HashMap class automatically
	 * resizes its hash table when the load factor reaches a specific threshold
	 * value. This threshold value can be set when the hash table is created, using
	 * the constructor public HashMap(int initialCapacity, float loadFactor) which
	 * also allows the initial capacity to be set. If you use a constructor that
	 * does not take one or the other of these two arguments, then the default
	 * values of capacity 101 and load threshold 75 percent will be used.
	 * 
	 */
}
