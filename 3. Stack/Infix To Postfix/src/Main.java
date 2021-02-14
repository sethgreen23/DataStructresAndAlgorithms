import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Deque<String> stack = new ArrayDeque<String>();
		String line = new Scanner(System.in).nextLine();
		Scanner input = new Scanner(line);
		
		while(input.hasNext()) {
			if(input.hasNextInt()) {
				System.out.print(input.next()+" ");
			}else {
				String character = input.next();
				if("+-/*".indexOf(character)>=0) {
					stack.push(character);
				}else if(character.equals(")")) {
					System.out.print(stack.pop()+" ");
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println("\nThank you for using out application :)");

	}

}

//( 80 - 30 ) * ( 40 + 50 / 10 )
//80 30 – 40 50 10 / + *

//output
/*
( 80 - 30 ) * ( 40 + 50 / 10 )
80 30 - 40 50 10 / + * 
Thank you for using out application :)
*/