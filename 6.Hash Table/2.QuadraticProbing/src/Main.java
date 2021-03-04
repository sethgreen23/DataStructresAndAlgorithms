
public class Main {
	private static final int CAPACITY = 11;
	private static int size = 0;
	private static boolean[] used = new boolean[CAPACITY];
	private static final int MASK = 0x7FFFFFFF;
	public static void main(String[] args) {
		printHash("TN");
		printHash("IT");
		printHash("GB");
		printHash("GER");
		printHash("HU");
		printHash("USA");
		printHash("CA");
		printHash("POL");
		printHash("SWE");
		printHash("DEN");
		printHash("POR");
	}
	private static void printHash(String string) {
		System.out.printf("hash(%s) = %s, load = %s%%%n", string,hash(string),100*size/CAPACITY);
		
	}
	private static Object hash(Object object) {
		size++;
		int h = (object.hashCode()&MASK)%CAPACITY;
		if(used[h]) {
			int h0 = h;
			int jump=1;
			while(used[h]) {
				h = ((h0+jump*jump)&MASK)%CAPACITY;
				if(size<used.length) {
					System.out.printf("%s ", h);
				}
				
				jump++;
				//System.out.println(jump);
			}
		}
		used[h]=true;
		
		return h;
	}

}
//OUTPUT
/*
hash(TN) = 9, load = 9%
hash(IT) = 4, load = 18%
hash(GB) = 1, load = 27%
hash(GER) = 8, load = 36%
hash(HU) = 7, load = 45%
9 1 6 hash(USA) = 6, load = 54%
9 1 6 2 hash(CA) = 2, load = 63%
8 0 hash(POL) = 0, load = 72%
8 0 5 hash(SWE) = 5, load = 81%
hash(DEN) = 3, load = 90%
hash(POR) = 10, load = 100%
*/

/*
Another collision resolution algorithm that usually performs better than linear probing is
called quadratic probing. This algorithm jumps over items in its probing, with the result that the
used components are more uniformly distributed with fewer large clusters. That improves performance because the resulting probe chains are shorter.
The essential difference here is in the sequence of index numbers probed within the while loop when a
collision occurs. Instead of searching linearly, it uses a squared increment. For example, when the insertion of "Ast" collides at index 3, linear probing continued probing at indexes 4, 5, 6, 7, 8, and 9 (in
Example 8.6). But with quadratic probing, only indexes 3, 4, 7, and 1 ( = 12 mod 11) are probed, using
successive jumps of 1, 4, and 9 (12, 22, and 32). Linear probing required 50 percent more probes.
The price that the quadratic probing algorithm pays for its improved performance is that it is
more likely to result in an infinite loop. That happens in Example 8.7 with the next insertion. The
string "Hof" hashes initially to index 3. After eight collisions, the linear probing algorithm found
a free cell at index 0 ( = 11 mod 11). But the probe sequence used on this item by the quadratic
probing algorithm is the same as for "Ast": 3, 4, 7, 1, 8, 6, 6, 8 1, 7, 4, 3, 4, . . . . This is
computed from the unmodulated quadratic sequence 3, 4, 7, 12, 19, 28, 39, 52, 67, 84, 103, 124,
147, . . . . This continues indefinitely, probing only the six indexes 3, 4, 7, 1, 8, and 6, all of
which have already been used. So even though the table is only 81% full, the insertion fails. That
can’t happen with linear probing
*/
 