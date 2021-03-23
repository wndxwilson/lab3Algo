import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {

    static  int[] generateNumers(int n,String type) {
        int [] values = new int[n];

        switch(type){
            case "ascending":
                for(int i=0;i<n;i++){
                    values[i] = i;
                }
                break;
            case "descending":
                for(int i=0;i<n;i++){
                    values[i] = n-1-i;
                }
                break;
            case "random":
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
    public static void main(String[] args) throws IOException {
        List<List<String>> data = new ArrayList<>();
        String [] type = new String[]{"ascending","descending","random"};

        //Merge sort
        SortingAlgo sort = new SortingAlgo();
        for(String t : type){
            for(int i = 1000;i<=100000;i = i+1000 ){
                List<String> row = new ArrayList<>();
                //set Array 
                sort.setArr(generateNumers(i, t));

                //sorting Algo
                sort.returnMergeSort();

                //add to list
                row.add(String.valueOf(i));
                row.add(String.valueOf( sort.getCompare()));
                row.add(String.valueOf(sort.getTime()));
                row.add("MergeSort");
                row.add(t);
                data.add(row);
            }
        }


        //insertion sort
        for(String t : type){
            for(int i = 1000;i<=100000;i = i+1000 ){
                List<String> row = new ArrayList<>();
                //set Array 
                sort.setArr(generateNumers(i, t));

                //sorting Algo
                sort.returnInsertionSort();

                //add to list
                row.add(String.valueOf(i));
                row.add(String.valueOf( sort.getCompare()));
                row.add(String.valueOf(sort.getTime()));
                row.add("InsertionSort");
                row.add(t);
                data.add(row);
            }
        }

        writeToCSV csv = new writeToCSV("Results");
        csv.writeData(data);

        
    }


}