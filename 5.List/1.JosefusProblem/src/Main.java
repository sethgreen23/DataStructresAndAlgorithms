import java.util.Iterator;

public class Main {

	public static final int SOLDIERS = 9;
	public static  final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) {
		Ring<String> group = new Ring<String>(); 
		for(int i=0;i<SOLDIERS;i++) {
			group.add(ALPHA.substring(i,i+1));
		}
		System.out.println(group);
		Iterator<String> iterator = group.iterator();
		
		String killer = iterator.next();
		StringBuilder show = new StringBuilder();
		while(group.size()>1) {
			String victim = iterator.next();
			show.append(killer+" killed "+victim+"\n");
			iterator.remove();
			killer = iterator.next();
		}
		System.out.println(show.toString());
		System.out.println("the only survivor is "+killer);
	}

}
/*
 The Ring list is instantiated at line 6 and loaded at
lines 7–9. The iterator it is obtained from the iterator() method at line 11. After advancing past A at
line 12, it advances past B at line 14, removes B at line 16, and then advances past C at line 17. The while
loop continues until only one soldier remains. Each iteration advances it past two elements, naming them
killer and victim, and removes the victim node.
 */