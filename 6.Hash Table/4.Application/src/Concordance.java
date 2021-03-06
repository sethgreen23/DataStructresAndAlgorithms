import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Concordance {
	/*
	 The TreeMap class extends the AbstractMap class and implements the SortedMap interface.
	 It is called a tree map because its backing structure is a binary search tree instead of a hash table
	 But it is still a map with key/value entries. As a binary search tree structure, it sacrifices its O(1)
	access time, but its keys are ordered.
	 */
//	private  Map<String,String> map = new HashMap<String,String>();
	private Map<String,String> map = new TreeMap<String,String>();
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
//OUTPUT using TreeMap alphabetically ordered output
/*
A=6, 23
AFTER=3
ALL=10, 10, 22, 29
AM=28
AMBITION=19, 24
AMBITIOUS=5, 13, 17, 20, 25
AN=9, 14, 26
AND=7, 8, 12, 14, 21, 21, 26, 32
ANSWER=7
ARE=10
ART=31
BE=4, 19
BEASTS=31
BROUGHT=15
BRUTISH=31
BRUTUS=4, 8, 9, 13, 14, 20, 21, 25, 27
BURY=2
BUT=13, 28
CAESAR=2, 4, 5, 7, 11, 17
CAPTIVES=15
CAUSE=29, 30
COESAR=18
COFFERS=16
COME=2, 11
COUNTRYMEN=1
CRIED=18
CROWN=23
D=7
DID=16, 17, 22, 24, 29
DISPROVE=27
DO=28
EARS=1
FAITHFUL=12
FAULT=6
FELD=31
FILL=16
FOR=9, 30
FRIEND=12
FRIENDS=1
FUNERAL=11
GENERAL=16
GOOD=3
.
.
.
.

*/

//OUTPUT using TreeMap alphabetically ordered output
/*
STERNER=19
SPEAK=11, 27, 28
COESAR=18
POOR=18
LOST=32
AFTER=3
HATH=5, 7, 15, 18
SHOULD=19
MOURN=30
THEY=10
CRIED=18
WHEN=18
BRUTISH=31
TOLD=5
WHICH=24
JUDGEMENT=31
YOUR=1
COME=2, 11
FUNERAL=11
IF=6
GRIEVOUSLY=7
IN=11
IS=3, 9, 14, 17, 21, 26
IT=4, 6, 6, 7
AM=28
AN=9, 14, 26
SEE=22
SURE=26
ARE=10
MADE=19
THRICE=23, 24
WITHOUT=29
THEN=30
THEM=3
MAN=9, 14, 21, 26
AMBITION=19, 24
KINGLY=23
A=6, 23
CROWN=23
BE=4, 19
ART=31
D=7
*/
