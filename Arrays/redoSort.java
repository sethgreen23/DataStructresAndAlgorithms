import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      //array to use for sorting
    //   int[] input = {36,33,35,34};
    //   System.out.println(Arrays.toString(input));
    
    //   System.out.print("Bubble Sort: "); bubleSort(input);
    
    //   System.out.print("Selection Sort: "); selectionSort(input);
    
    //   System.out.print("Insertion Sort: "); insertionSort(input);
    
    //   System.out.println("Shell Sort: "); shellSort(input);
    
    //   System.out.println("merge Sort: "); mergeSort(input,0,input.length);
    //   System.out.println(Arrays.toString(input));
    
    //   System.out.println("quick Sort: "); quickSort(input,0,input.length);
    //   System.out.println(Arrays.toString(input));
    
    //   int[] input = {20,12,5,7,9,19,16};
    //   System.out.println(Arrays.toString(input));
    //   countingSort(input,4,20);
    //   System.out.print("Counting sort: ");System.out.println(Arrays.toString(input));
      
      int[] input = {4512,7845,9547,1327,1325};
      System.out.println(Arrays.toString(input));
      radixSort(input, 4, 10);
      System.out.println("Final result: "+Arrays.toString(input));
    }
    
    
    //radix sort
    public static void radixSort(int[] input, int width, int radix){
        for(int i=0;i<width;i++){
            singleRadix(input,i,radix);
        }
    }
    
    public static void singleRadix(int[] input, int position, int radix){
        int numberOfElements = input.length;
        int[] count = new int[radix];
        for(int i=0;i<numberOfElements;i++){
            count[getNumber(input[i],position,radix)]++;
        }
        
        //adjust the elements
        for(int i=1;i<count.length;i++)
            count[i]+=count[i-1];
        
        int[] temp = new int[numberOfElements];
        for(int i=input.length-1;i>=0;i--){
            temp[--count[getNumber(input[i],position,radix)]]=input[i];
        }
        System.arraycopy(temp,0,input,0,numberOfElements);
    }
    
    public static int getNumber(int value, int position,int radix){
        return value/(int)Math.pow(radix, position)%radix;
    }
    
    
    
    //counting sort my version statble
    public static void countingSort1(int[] input, int min, int max){
        int numberOfElements = input.length;
        int[] count = new int[max-min+1];
        for(int i=0;i<input.length;i++){
            count[input[i]-min]++;
        }
        // System.out.println(Arrays.toString(count));
        //adjusting the couting
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        // System.out.println(Arrays.toString(count));
        int[] temp = new int[numberOfElements];
        for(int i=input.length-1; i>=0; i--){
            temp[--count[input[i]-min]]=input[i];
        }
        System.arraycopy(temp,0,input,0,numberOfElements);
    }
    //counting sort version tutorial unstatble
    public static void countingSort(int[] input, int min, int max){
        // 20-4=16+1
        // 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        int[] count = new int[max-min+1];
        //counting the elements
        for(int i=0;i<input.length;i++){
            count[input[i]-min]++;
        }
        int[] temp = new int[input.length];
        for(int i=min,j=0;i<=max;i++){
            
            while(count[i-min]-->0){
                temp[j++]=i;
            }
        }
        System.arraycopy(temp,0,input,0,temp.length);
    }
    
    
    
    
    //quick sort
    public static void quickSort(int[] input, int start, int end){
        if(end-start<2)
            return;
        int pivot = partition(input, start,end);
        quickSort(input,start,pivot);
        quickSort(input, pivot+1,end);
    }
    
    public static int partition(int[] input, int start, int end){
        int i = start;
        int j = end;
        int pivot = input[start];
        while(i<j){
            while(i<j && input[--j]>=pivot);
            if(i<j)
            input[i]=input[j];
            while(i<j && input[++i]<=pivot);
            if(i<j)
            input[j]=input[i];
        }
        input[j]=pivot;
        return j;
    }
    
    
    
    //merge sort
    public static void mergeSort(int[] input, int start, int end){
        if(end - start <2)
            return;
        int mid = (end+start)/2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }
    public static void merge(int[] input, int start, int mid, int end){
        if(input[mid-1]<input[mid])
            return;
        int[] temp = new int[end-start];
        int i = start;
        int j = mid;
        int tempIndex = 0;
        while(i<mid && j<end){
            temp[tempIndex++]=input[i]<input[j]?input[i++]:input[j++];
        }
        System.arraycopy(input,i,input,start+tempIndex,mid-i);
        System.arraycopy(temp,0,input,start,tempIndex);
        
    }
    
    
    
    //shell sort
    public static void shellSort(int[] input){
        for(int gap = input.length/2; gap>0;gap/=2){
            for(int i = gap; i<input.length;i++){
                int selected = input[i];
                int j=i;
                while(j>=gap && input[j-gap]>selected){
                    System.out.println("i: "+i+" / j: "+j);
                    input[j]=input[j-gap];
                    j-=gap;
                }
            input[j]=selected;
            }
        }
        System.out.print("Final result: "); System.out.println(Arrays.toString(input));
    }
    
   
    
    //insertion sort
    public static void insertionSort(int[] input){
        for(int i=1;i<input.length;i++){
            int selected = input[i];
            int j;
            for(j=i;j>0 && input[j-1]>selected;j--){
                input[j]=input[j-1];
            }
            input[j]=selected;
            
        }
        System.out.print("Final result: "); System.out.println(Arrays.toString(input));
    }
    
    
    
    //selection sort
    public static void selectionSort(int[] input){
       for(int i=input.length-1;i>0;i--){
           int largest = i;
           for(int j=0;j<=i;j++){
               if(input[largest]<input[j])
                largest = j;
           }
           swap(input, largest, i);
       }
           System.out.print("Final result: "); System.out.println(Arrays.toString(input));
    }
    
    
    
    
    //buble sort
    public static void bubleSort(int[] input){
        for(int i=input.length;i>0;i--){
            for(int j=1;j<i;j++){
                if(input[j-1]>input[j])
                    swap(input, j, j-1);
            }
        }
        System.out.println("Final result: ");
        System.out.println(Arrays.toString(input));
    }
    
    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i]=input[j];
        input[j]=temp;
    }
  
    
}