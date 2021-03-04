
public class Main {
	private static final int CAPACITY=11;
	private static final int MASK = 0x7FFFFFFF;
	private static boolean[] used = new boolean[CAPACITY];
	private static int size = 0;
	public static void main(String[] args) {
		print("TN");
		print("GB");
		print("GER");
		print("FR");
		print("HU");
		print("GRE");
		print("IT");
		print("POL");
		print("RUS");
		print("USA");
		print("CA");

	}
	private static void print(String string) {
		System.out.printf("hash(%s) = %s , load = %s%%%n",string,hash(string),100*size/CAPACITY);
		
	}
	private static Object hash(Object object) {
		size++;
		//& it will clean up the sign we will get integer sign free
		//exp (0110 & 1111 =>0110) and (0110 & 1001 => 0000)
		//the second term lead the conversion by setting any element with value 1 to stay the same in the same position in the first term
		//and setting any element to 0 if the corresponding position of the second term have 0 on it
		int h = (object.hashCode()&MASK)%CAPACITY;
		while(used[h]) {
			h=(h+1)%CAPACITY;
			System.out.printf("%s ",h);
		}
		used[h]=true;
		return h;
	}

}
//OUTPUT
/*
hash(TN) = 9 , load = 9%
hash(GB) = 1 , load = 18%
hash(GER) = 8 , load = 27%
9 10 hash(FR) = 10 , load = 36%
hash(HU) = 7 , load = 45%
hash(GRE) = 2 , load = 54%
hash(IT) = 4 , load = 63%
8 9 10 0 hash(POL) = 0 , load = 72%
0 1 2 3 hash(RUS) = 3 , load = 81%
9 10 0 1 2 3 4 5 hash(USA) = 5 , load = 90%
9 10 0 1 2 3 4 5 6 hash(CA) = 6 , load = 100%
*/
