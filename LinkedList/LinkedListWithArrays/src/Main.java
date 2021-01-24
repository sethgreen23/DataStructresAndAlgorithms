import java.util.*;
public class Main {
    public static void main(String args[]) {
      int[] input = {7,1,2,25,3,20,19,13};
      int[] arr=new int[2];
      int[] indexes=new int[2];
      Object[] result =order(input,arr,indexes);
      arr = (int[])result[0];
      indexes = (int[])result[1];
      print(indexes,arr);
    }
    
    public static Object[] order(int[] input, int[] arr, int[] indexes){

        int free=0;
        //get a random index for the first element
        int rand =(int)(Math.random()*4)+1;
        arr = resize(arr,rand);
        indexes = resize(indexes,rand);
        arr[rand]=input[0]; 
        indexes[free]=rand;
        indexes[rand]=-1;
        free=rand+1;
        //resize array
        arr = resize(arr);;
        indexes = resize(indexes);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(indexes));
        System.out.println("----------------");
        for(int i=1;i<=input.length-1;i++){
            int current = input[i];
            int j=0;
            while(indexes[j]!=-1 && arr[indexes[j]]<=current){
                j=indexes[j];
//                System.out.print(j+" "+indexes[j]+" / ");
            }  
            // System.out.println()
            if(indexes[j]==-1) {
                arr[free]=current;
                indexes[j]=free;
                indexes[free++]=-1;
                //resize array
                arr = resize(arr);;
                indexes = resize(indexes);
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(indexes));
                System.out.println("----------------");
            }
            else if(arr[indexes[j]]>current){
                arr[free]=current;
                indexes[free]=indexes[j];
                indexes[j]=free++;
                //resize array
                arr = resize(arr);;
                indexes = resize(indexes);
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(indexes));
                System.out.println("----------------");
//                System.out.println(free);
            }
            
            
        }
        return new Object[] {arr,indexes};
    }
    
    private static int[] resize(int[] arr,int extention) {
		int[] temp = new int[arr.length+extention];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		return temp;
	}
    private static int[] resize(int[] arr) {
    	return resize(arr,1);
    }
	public static void print(int[] k,int[] arr) {
    	int i=0;
    	while(k[i]!=-1) {
    		System.out.println(arr[k[i]]+", ");
    		i=k[i];
    	}
    }
}