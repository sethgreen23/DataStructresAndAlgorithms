import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Concordance {

	private static Map<String, String> map = new TreeMap<>();
	private static Set<String> words = new TreeSet<>();
	
	public Concordance(String source, String filter) {
		//reading and storing the filter strings
		File filterFile=null ;
		File sourceFile=null;
		Scanner input=null;
		int lineCount=0;
		try {
			filterFile = new File(filter);
			System.out.println("Filter file opened !");
			input = new Scanner(filterFile);
			while(input.hasNext()) {
				String[] line = input.nextLine().split(" ");
//				System.out.println(Arrays.toString(line));
				for(int i=0;i<line.length;i++) {
					String inputWord = line[i].toUpperCase();
					words.add(inputWord);
				}
			}
//			System.out.println(words);
			System.out.println("Filter file closed!");
			System.out.println("Source file opened!");
			sourceFile = new File(source);
			input = new Scanner(sourceFile);
			while(input.hasNext()) {
				lineCount++;
				String[] line = input.nextLine().split("[\\s',;:!?.-]+");
//				System.out.println(Arrays.toString(line));
				for(int i=0;i<line.length;i++) {
					String listing = line[i].toUpperCase();
					//we filter out the element that we grab from the source file
					//the one that are included in the filter file we dont include them in the destination file
					if(words.contains(listing))
						continue;
					String exist = map.get(listing);
					if(exist !=null) {
						exist = map.get(listing)+", "+lineCount;
					}else {
						exist = ""+lineCount;
					}
					map.put(listing, exist);
				}
			}
//			System.out.println(map);
			System.out.println("Source file closed!");
			input.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			input.close();
		}
			
	}
	
	public void printInFile(String destination) {
		//writing the element from the map to destination file
		PrintWriter write = null;
		try {
			File destinationFile = new File(destination);
			System.out.println("Print on destination start!");
			write = new PrintWriter("destination.txt");
			for(Map.Entry<String, String> entery : map.entrySet()) {
				write.println(entery);
			}
			System.out.println("Print on destination ended!");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			
			write.close();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Concordance c = new Concordance("shakespear.txt","words.txt");
		c.printInFile("destination.txt");
	}

}
