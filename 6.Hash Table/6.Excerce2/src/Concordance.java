import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Concordance {

	private static Map<String, String> map = new TreeMap<>();
	
	public Concordance(String source) {
		File file = null;
		Scanner input=null;
		try {
			file = new File(source);
			input = new Scanner(file);
			while(input.hasNext()) {
				String[] line = input.nextLine().split("[!\\s',.?\\-;:]+");
//				System.out.println(Arrays.toString(line));
				for(int i =0;i<line.length;i++) {
					String word = line[i].toUpperCase();
					if(map.containsKey(word)) {
						int n = Integer.parseInt(map.get(word));
						n++;
						map.put(word, ""+n);
					}else {
						map.put(word, "1");
					}
				}
			}
//			System.out.println(map);
			
			System.out.println("the file is mapped to the map!");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			input.close();
		}
	}
	
	public void printToDestination(String destination) {
		PrintWriter write = null;
		File file=null;
		try {
			file = new File(destination);
			write = new PrintWriter(file);
			for(Map.Entry<String, String> entery : map.entrySet()) {
				write.println(entery);
			}
			System.out.println("finished writing into the destination file!");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			//need to close otherwise you wont have anything writen onto the file
			write.close();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Concordance c = new Concordance("shakespear.txt");
		c.printToDestination("destination.txt");
	}

}
