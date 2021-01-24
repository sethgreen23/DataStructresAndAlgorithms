import java.util.*;
public class sorting {
    public static void main(String args[]) {
    //   int[] input = {80,15,90,7,85,1,22,5};
    //   int[] input = {36,34,35,33,32};
      
    //   System.out.println("Bubble sort");
    //   bubleSort(input);
    //   System.out.println(Arrays.toString(input));
    
    // System.out.println("Selection sort");
    // selectionSort(input);
    // System.out.println(Arrays.toString(input));
    
    // System.out.println("Insertion sort");
    // insertionSort(input);
    // System.out.println(Arrays.toString(input));
    
    // System.out.println("Shell sort");
    // shellSort(input);
    // System.out.println(Arrays.toString(input));
    
    // System.out.println("Merge sort");
    // mergeSort(input,0,input.length);
    // System.out.println(Arrays.toString(input));
    
    // System.out.println("Quick sort");
    // quickSort(input, 0, input.length);
    // System.out.println(Arrays.toString(input));
    
    
    // System.out.println("Count sort my implementation number one");
    // int[] input = {2,5,9,8,2,8,7,10,4,3};
    // System.out.println(Arrays.toString(input));
    // int max = max(input);
    // int[] countArray=new int[max];
    // countSortOne(input,countArray);
    // System.out.println(Arrays.toString(input));
    
    
    // int[] input = {10,20,5,19,14,9,9};
    // System.out.println("Count sort my implementation number two:");
    // System.out.println(Arrays.toString(input));
    // countSortTwo(input,5,20);
    // System.out.println(Arrays.toString(input));

    // System.out.println("Count sort her implementation");
    // int[] input = {2,5,9,8,2,8,7,10,4,3};
    // System.out.println(Arrays.toString(input));
    // countSort(input,1,10);
    // System.out.println(Arrays.toString(input));

    int[] input = {1330, 8792, 1594, 4725, 4586, 5729};
    radixSort(input, 1, 9, 2);
    System.out.println(Arrays.toString(input));
    System.out.println("RESULT ARRAY");
    System.out.println(Arrays.toString(new int[]{4725,5729,1330,4586,8792,1594}));
    }
    
    //radix sort
    public static void radixSort(int[] input, int min, int max,int position){
        //i need to to do the counting sort
            //create an array that contains the counting elements
            //loop throw the unsorted array and to count the number of appearance of the numbers
                //for this i need to get the number the tenth position
                //i add one on the countArray[input[i]-min]++ 
        int[] counting = new int[max-min+1];
        countOccurance(counting,input,position,min);
        // System.out.println(Arrays.toString(counting));
        

        //i have to count the number of element on the same spot and before it
            //here i have to go from the right most of the counting array and for every
            //current element i have to loop throw them and i add the content of the index below the current element
        countPrevious(counting);   
        //System.out.println(Arrays.toString(counting));
            
            
            
        //i have to go throw the counting array and sort the elements in the temporary array
            //i loop the unsorted array from the right most of it and for every number i get the tenth position
            //and what i have to do then is to look for the index where i will put it in the temporary array
            //tempArray[--countArray[i]]=number
        int[] temp = new int[input.length];
        sortingInTempArray(temp, input, counting, position, min);
        //System.out.println(Arrays.toString(temp));

        //i have to copy the element from the temporary array to the unsorted array
            //i have to loop throw the unsorted array and copy its elements in the unsorted array 
         System.arraycopy(temp,0,input,0,temp.length);   
        //and thats it
    }
    
    public static int getNumber(int position, int number){
        String str = number+"";
        int result = -1;
        for(int i=str.length()-1,j=1;i>=0;i--,j++){
            if(position == j){
                result = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return result;
    }
    
    public static void countPrevious(int[] input){
        for(int i=input.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                input[i]+=input[j];
            }
        } 
    }
    
    public static void countOccurance(int[] counting,int[] input, int position, int min){
        for(int i=0;i<input.length;i++){
            counting[getNumber(position, input[i])-min]++;
        }
    }

    public static void sortingInTempArray(int[] temp, int[] input, int[] counting, int position, int min){
        for(int i=input.length-1;i>=0;i--){
            int number = getNumber(position,input[i])-min;
            temp[--counting[number]]=input[i];
        }
    }


    //count sort her implementation
    public static void countSort(int[] input, int min, int max){
        int[] countArray = new int[(max-min)+1];
        
        for(int i=0; i<input.length;i++){
            countArray[input[i]-min]++;
        }
        
        for(int i=min,j=0; i<=max; i++){
            while(countArray[i-min]>0){
                input[j++]=i;
                countArray[i-min]--;
            }
        }
        
    }
    
    //count sort my implementation number two
    public static void countSortTwo(int[] input,int min, int max){
        int[] countingArray = new int[max-min+1];
        for(int i=0;i<input.length;i++){
            countingArray[input[i]-min]++;
        }
        
        
        for(int i=0,j=0;i<countingArray.length;i++){
            while(countingArray[i]>0){
                input[j++]=i+min;
                countingArray[i]--;
            }
        }
    }


    //count sort my implementation number one
    public static void countSortOne(int[] input, int[] count){
        for(int i=0;i<input.length;i++){
            count[input[i]-1]+=1;
        }
        
        for(int i=0,j=0;i<count.length;i++){
            int countNumber = count[i];
            while(countNumber>0){
                input[j++]=i+1;
                countNumber--;
            }
            
        }
    }
    public static int max(int[] input){
        int max = input[0];
        for(int i=1;i<input.length;i++){
            if(input[i]>max){
                max = input[i];
            }
        }
        return max;
    }
    
    
    //quick sort
    public static void quickSort(int[] input, int start, int end){
        if(end-start<2)
            return;
            
        int pivot = partition(input, start, end);
        quickSort(input, start, pivot);
        quickSort(input, pivot+1, end);
    }
    
    public static int partition(int[] input, int start, int end){
        
        int pivot = input[start];
        int i=start;
        int j= end;
        
        while(i<j){
            
            while(i<j && input[--j]>pivot);
            input[i]=input[j];
            
            while(i<j && input[++i]<pivot);
            input[j]=input[i];
        }
        input[j]=pivot;
        return j;
    }
    
    //merge sort
    public static void mergeSort(int[] input, int start, int end){
        if(end - start < 2)
            return;
        
        int mid = (end+start)/2;
        
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }
    
    public static void merge(int[] input, int start, int mid, int end){
        if(input[mid-1]<=input[mid])
            return;
        
        int i=start;
        int j= mid;
        int tempIndex =0;
        int[] temp = new int[end-start];
        while(i<mid && j<end){
            temp[tempIndex++]=input[i]<=input[j]?input[i++]:input[j++];
        }
        System.arraycopy(input, i, input, start+tempIndex,mid-i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
    
    //shell sort
    public static void shellSort(int[] input){
        for(int gap = input.length/2; gap>0; gap/=2){
            for(int i=gap; i<input.length; i++){
                int selection = input[i];
                int j = i;
                for(;j>=gap && input[j-gap]>selection;j-=gap){
                    input[j]=input[j-gap];
                }
                input[j]=selection;
            }
        }
    }
    
    //insertion sort
    public static void insertionSort(int[] input){
        for(int i=1; i<input.length; i++){
            int selection = input[i];
            int j=i;
            for(;j>0 && input[j-1]>selection;j--){
                input[j]=input[j-1];
            }
            input[j]=selection;
        }
    }
    
    //selection sort
    public static void selectionSort(int[] input){
        for(int i=input.length-1;i>0;i--){
            int largest = 0;
            for(int j=1;j<=i;j++){
                if(input[j]>input[largest]){
                    largest = j;
                }
            }
            swap(input,i,largest);
        }
    }
    
    //buble sort
    public static void bubleSort(int[] input){
        for(int i=input.length-1;i>0;i--){
            for(int j=1;j<=i;j++){
                if(input[j-1]>input[j]){
                    swap(input,j,j-1);
                }
            }
        }
    }
    
    public static void swap(int[] input, int i, int j){
        int temp = input[j];
        input[j]=input[i];
        input[i]=temp;
    }
}

  