import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      String[] input = {"bcdef","dbaqc","abcde","omadd","bbbbb"};
      System.out.println("Before radix sort: "+Arrays.toString(input));
      radixSort(input, 5, 26);
      System.out.println("After radix sort: "+Arrays.toString(input));
    }
    
    public static void radixSort(String[] input, int width, int radix){
        for(int i=width-1;i>=0;i--){
            singleRadix(input, i, radix);
        }
        
    }
    
    public static void singleRadix(String[] input, int position, int radix){
        int start = (int)'a';
        int numberElements = input.length;
        //make counting array
        int[] count = new int[radix];
        
        for(int i=0;i<numberElements;i++){
            count[getDigit(input[i],position,start)]++;
        }
        System.out.println("Counting array : "+Arrays.toString(count));
        
        //adjust
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        System.out.println("Adjusted counted array : ---------------------- "+Arrays.toString(count));
        
        //sort the mother fucker
        String[] temp = new String[numberElements];
        for(int i=numberElements-1;i>=0;i--){
            temp[--count[getDigit(input[i],position,start)]]=input[i];
        }
        System.arraycopy(temp,0,input,0,numberElements);
    }
    
    public static int getDigit(String value , int position, int start){
        return value.charAt(position)-start;
    }
   

    
}