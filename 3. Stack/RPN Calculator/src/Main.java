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
