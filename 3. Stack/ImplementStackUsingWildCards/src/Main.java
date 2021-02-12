import java.util.EmptyStackException;

public class Main {

	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>(10);
		System.out.println("isEmpty() :"+stack.isEmpty());
		stack.push("Fr");
		stack.push("GB");
		stack.push("USA");
		stack.push("HU");
		stack.push("RUS");
		stack.push("CH");
		stack.push("CA");
		stack.push("MEX");
		stack.push("SW");
		stack.push("ALG");
		stack.push("MAL");
		stack.print();
		System.out.printf("Peek : %s%n",stack.peek());
		System.out.println("isEmpty() :"+stack.isEmpty());
		System.out.println("Size of the stack: "+stack.size());
		System.out.println("Poping last element :"+stack.pop());
		stack.print();
		System.out.printf("Peek : %s%n",stack.peek());
		System.out.println("******************");
		ArrayStack<Integer> stack1 = new ArrayStack<Integer>(5);
		System.out.println("isEmpty() :"+stack1.isEmpty());
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		stack1.push(6);
		stack1.print();
		System.out.printf("Peek : %s%n",stack1.peek());
		System.out.println("isEmpty() :"+stack1.isEmpty());
		System.out.println("Size of the stack: "+stack1.size());
		System.out.println("Poping last element :"+stack1.pop());
		stack1.print();
		System.out.printf("Peek : %s%n",stack1.peek());
	}

}

//output:
//isEmpty() :true
//MAL  => ALG  => SW  => MEX  => CA  => CH  => RUS  => HU  => USA  => GB  => Fr 
//Peek : MAL
//isEmpty() :false
//Size of the stack: 11
//Poping last element :MAL
//ALG  => SW  => MEX  => CA  => CH  => RUS  => HU  => USA  => GB  => Fr 
//Peek : ALG
//******************
//isEmpty() :true
//6  => 5  => 4  => 3  => 2  => 1 
//Peek : 6
//isEmpty() :false
//Size of the stack: 6
//Poping last element :6
//5  => 4  => 3  => 2  => 1 
//Peek : 5
