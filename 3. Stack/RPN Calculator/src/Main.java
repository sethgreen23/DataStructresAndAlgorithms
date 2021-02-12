import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Deque<String> operation = new ArrayDeque<String>();
		Scanner in = new Scanner(System.in);
		
		while(true) {
			char input = in.nextLine().charAt(0);
			
			if( input=='+' || input=='-' || input=='*' || input=='/') {
				double x = Double.parseDouble(operation.pop());
				double y = Double.parseDouble(operation.pop());
				double z=0;
				switch(input) {
				case '+':
					z=x+y;
					break;
				case '-':
					z=x-y;
					break;
				case '*':
					z=x*y;
					break;
				case '/':
					try {
						if(y==0) {
							throw new ArithmeticException();
						}
					}catch(ArithmeticException e) {
						System.out.println("You cant devide by 0");
						return ;
					}
						z=x/y;
					break;					
				}
				System.out.printf("%s%s%s = %s%n",x,input,y,z);
				operation.push(String.valueOf(z));
			}else if(input == 'Q' || input == 'q') {
				System.out.println("Thank you for Using our Application.See you next time ;)");
				return;
			}else {
				operation.push(Character.toString(input));
			}
		}
		
		
	}

}
//output:
//5
//9
//+
//9.0+5.0 = 14.0
//3
///
//3.0/14.0 = 0.21428571428571427
//q
//Thank you for Using our Application.See you next time ;)

/*
Although the stack data structure is one of the simplest, it is essential in certain important
applications. Some of these are illustrated in the following examples.
An arithmetic expression is said to be in postfix notation (also called reverse Polish notation,
or RPN) if each operator is placed after its operands. For example, the postfix expression for
3*(4 + 5) is 3 4 5 + *. [The expression 3*(4 + 5) is called an infix expression.] Postfix
expressions are easier to process by machine than are infix expressions. Calculators that process
postfix expressions are called RPN calculators.

 */

/*
 At line 3, the program instantiates a stack of strings, like the one in Example 5.1 on page 103. Then it
goes into an infinite while loop at line 5, interactively reading a string on each iteration at line 6.
If the user inputs anything other than +, -, *, /, q, or Q, the program assumes it is a number and pushes
it onto the stack at line 23. If it is one of the four arithmetic operations, then the top two numbers are
popped off the stack at lines 9–10 and the operation is applied to them. The result is printed at line 18 and
then pushed onto the stack at line 19.
The program ends when the user enters q or Q (for “quit”).
Human readers tend to prefer infix to postfix notation for arithmetic expressions. The following example converts a given infix expression to postfix.
 */
