import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concordance {
	private  Map<String,String> map = new HashMap<String,String>();
	
	public Concordance(String file) {
		// get the file to be read
		//get everyline in the file
			//split the line in words
				//loop throw the word of each line
					//increment the line count
					//capitalize the word
					//check if the word exist in the map
						//yes then get the value of the key and concatenate it with the new line number and ", "
						//if no then put the line number in the map value
		//close the reader
		
		int lineCount =0;
		Scanner input=null;
		try {
			File fileInput = new File(file);
			input = new Scanner(fileInput);
			while(input.hasNextLine()) {
				++lineCount;
				String line = input.nextLine();
				//split when ever you find space or punctuation if once of manytimes
				String[] arrayLine = line.split("[,\\s!.;'-:?]+");
//				System.out.println(Arrays.toString(arrayLine));
				for(int i=0;i<arrayLine.length;i++) {
					String word = arrayLine[i].toUpperCase();
					String listing = "";
						if(map.containsKey(word)) {
							listing = map.get(word)+", "+lineCount;
						}else {
							listing = ""+lineCount;
						}
						map.put(word, listing);					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			input.close();
			System.out.println("File processed well!");
		}
	}
	
	public void write(String file) {
		PrintWriter print = null;
		try{
			print = new PrintWriter(file);
			for(Map.Entry<String, String> entery : map.entrySet()) {
				print.println(entery);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			print.close();
			System.out.println("File out wrote well!");
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Concordance c = new Concordance("shakespear.txt");
		c.write("shakespearOut.txt");

	}

}
