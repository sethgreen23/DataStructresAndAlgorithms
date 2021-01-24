package deleteElementInArray;

import java.util.Arrays;

public class DeleteElement {

	public static void main(String[] args) {
		int[] a = {33, 55, 77, 99, 77, 55, 33, 0};
		print(a);
		a=deleteFirstOccurence(a,6,55);
		print(a);
	}

	private static int[] deleteFirstOccurence(int[] a, int n, int x) {
		int number=a.length;
		int i=0;
		while(i<n && a[i]<=x) {
			i++;
		}
		if(i<n) {
			System.arraycopy(a, i, a, i-1, number-i);//8-2=6
			--number;
		}
		int[] a1=new int[number];
		System.arraycopy(a,0,a1,0,number);
		return a1;
	}

	private static void print(int[] a, int n) {
		// TODO Auto-generated method stub
		System.out.printf("{%s",a[0]);
		for(int i=1;i<n;i++) {
			System.out.printf(", %s", a[i]);
		}
		System.out.println("}");
	}
	private static void print(int[] a) {
		print(a,a.length);
	}

}
