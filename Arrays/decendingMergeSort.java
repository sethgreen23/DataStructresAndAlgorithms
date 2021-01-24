import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      int[] input = {36,33,35,34,25,31,28,30,19};
      System.out.println(Arrays.toString(input));
      mergeSort(input, 0, input.length);
      System.out.println("Final result: "+Arrays.toString(input));
    }
    
    public static void mergeSort(int[] input, int start, int end){
        if(end-start<2)
            return;
        int mid = (end+start)/2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }
    
    public static void merge(int[] input, int start, int mid, int end){
        if(input[mid-1]>input[mid])
            return;
        int i = start;
        int j = mid;
        int[] temp = new int[end-start];
        int tempIndex = 0;
        
        while(i<mid && j<end){
            //we add the greater elements to the temp array
            temp[tempIndex++]=input[i]>=input[j]?input[i++]:input[j++];
        }
        //in case we have [36] [33] temp => [36,.] 
        // the next line wont work because mid-i =0 then we keep the 33 in its position we just copy temp to the original one
        System.arraycopy(input,i,input,start+tempIndex,mid-i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}