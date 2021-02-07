import java.util.EnumSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		EnumSet<Month> spring = EnumSet.range(Month.MAR,Month.JUN);
		System.out.println(spring);
		EnumSet<Month> restOfMonths = EnumSet.complementOf(spring);
		System.out.println(restOfMonths);
		EnumSet<Month> shortMonths = EnumSet.of(Month.SEP, Month.APR, Month.JUN, Month.NOV, Month.FEB);
		System.out.println(shortMonths);
		shortMonths.addAll(spring);
		System.out.println(shortMonths);
	}
}
//output
/*
[MAR, APR, MAI, JUN]
[JAN, FEB, JUIL, AUG, SEP, OCT, NOV, DEC]
[FEB, APR, JUN, SEP, NOV]
[FEB, MAR, APR, MAI, JUN, SEP, NOV]
 */

/*
 *use static methods thats why you need to use EnumSet in declaration not a polymorphic class
 *The enum type Month is defined at line 3. Variables of that type can have only those 12 specified values
(or null). At line 7, the EnumSet spring is instantiated by invoking the static range() method of the
EnumSet class. Notice that this method does not adhere to Java’s “left-continuous” policy (see page 82):
the resulting set includes both of the specified elements MAR and JUN.
The EnumSet class’s complementOf() and of() methods are invoked at lines 9 and 11, respectively.
These work as described in the Javadoc, shown in Figure 4.8 on page 84. The addAll() method is tested
at line 13, producing the union of the shortMonths and spring sets.
*/