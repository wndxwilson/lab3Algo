import java.util.Random;

public class MainApp {

    static  int[] generateNumers(int n,int type) {
        int [] values = new int[n];

        switch(type){
            case 1:
                for(int i=0;i<n;i++){
                    values[i] = i;
                }
                break;
            case 2:
                for(int i=0;i<n;i++){
                    values[i] = n-1-i;
                }
                break;
            case 3:
                Random rand = new Random();
                for(int i=0;i<n;i++){
                    values[i] = rand.nextInt(n);
                }
                break;
            default:
                values = null;
        }
        
        return values;
        
    }

    static  void printNumbers(int[] arr){
        if(arr==null)
            return;
        int size = arr.length;
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }

    //Main code
    public static void main(String[] args) {
        int [] test;
        int [] sorted;
        //GenerateNumbers(n,type)
        //n is the list of number
        //type, 1 - assending 2 - decending 3 - random
        test = generateNumers(10,2);
        SortingAlgo sort = new SortingAlgo(test);
        printNumbers(test);
        sorted = sort.returnMergeSort();
        //Uncomment to try insertion sort
        //sorted = sort.insertionSort();
        printNumbers(sorted);
    
    }


}