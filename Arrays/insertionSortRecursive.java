import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      int[] input = {36,33,35,34};
      System.out.println(Arrays.toString(input)+"\n");
    //   insertionSort(input);
    //   insertionSortMe(input,1);
      insertionSortHer(input,input.length);
      System.out.println("\n"+Arrays.toString(input));
    }
    
    // public static void insertionSort(int[] input){
    //     for(int i = 1;i<input.length;i++){
    //         int selected = input[i];
            
    //         int j=i;
    //         while(j>0 && input[j-1]>selected){
    //             input[j]=input[j-1];
    //             j--;
    //         }
    //         input[j]=selected;
    //     }
    // }
    
    //my implementation
    public static void insertionSortMe(int[] input, int start){
        if(start>=input.length)
            return;
        int selected = input[start];
        sort(input, start,selected);
        insertionSortMe(input, start+1);
    }
    public static  void sort(int[] input, int start,int selected){
        int i = start;
        while(i>0 && input[i-1]>selected){
            input[i]=input[i-1];
            i--;
        }
        input[i]=selected;
    }
    //her implementation
    // public static void insertionSort(int[] input){
    //     for(int i = 1;i<input.length;i++){
    //         int selected = input[i];
            
    //         int j=i;
    //         while(j>0 && input[j-1]>selected){
    //             input[j]=input[j-1];
    //             j--;
    //         }
    //         input[j]=selected;
    //     }
    // }
    public static void insertionSortHer(int[] input,int numberElements){
        if(numberElements<2)
            return;
        
        insertionSortHer(input, numberElements-1);
        
        int selection = input[numberElements-1];
        
        int i =numberElements-1;
        while(i>0 && input[i-1]>selection){
            input[i]=input[i-1];
            i--;
        }
        input[i]=selection;
        
        System.out.println("Result array for number of elements : "+(numberElements));
        for(int j=0;j<input.length;j++){
            System.out.print(input[j]+",");
        }
        System.out.println("");
        System.out.println("---------------");
    }
    
}