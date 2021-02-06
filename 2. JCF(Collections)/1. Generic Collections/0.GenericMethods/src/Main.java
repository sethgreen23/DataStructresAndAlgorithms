
public class Main {

	public static void main(String[] args) {
		args = new String[] {"GB","JP","HU","CA","USA"};
		print(args);

	}

	private static <E> void print(E[] args) {
		// TODO Auto-generated method stub
		for(E e : args) {
			System.out.printf("%s, ", e);
		}
	}

}

//output
//GB, JP, HU, CA, USA, 
/*
 The method is identified as generic by the <E> specifier at line 7. This allows the type parameter E to be
used in place of an actual type in the method block at line 12.
 */