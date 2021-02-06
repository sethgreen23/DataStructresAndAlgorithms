import java.util.Comparator;

public class CompareWithReverse implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		StringBuilder one = new StringBuilder(o1);
		StringBuilder two = new StringBuilder(o2);
		o1=one.reverse().toString();
		o2=two.reverse().toString();
		return o1.compareTo(o2);
	}

	/*
	 *The separate RevStringComparator class implements the Comparator interface for String objects.
		t defines its compare() method by applying the String class’s CompareTo() method to the reversed
	 * */

}
