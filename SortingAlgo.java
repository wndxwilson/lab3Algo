public class SortingAlgo {
    private int[] arr;
    private int size;

    SortingAlgo(int[] arr){
        this.arr = arr;
        this.size = arr.length;   
    }

    public int[] insertionSort(){
        for(int i =1;i<this.size;i++){
            for(int j=i;j>0;j--){
                if(this.arr[j] < this.arr[j-1])
                    swap(j,j-1);
                else
                    break;
            }
        }
        return this.arr;
    }   

    private void swap(int a, int b){
        int temp = a;
        temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    public int[] returnMergeSort(){
        mergeSort(this.arr, this.size);
        return this.arr;
    }

    private static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
    
        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n-mid);

        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {
       
          int i = 0, j = 0, k = 0;
          while (i < left && j < right) {
              if (l[i] <= r[j]) {
                  a[k++] = l[i++];
              }
              else {
                  a[k++] = r[j++];
              }
          }
          while (i < left) {
              a[k++] = l[i++];
          }
          while (j < right) {
              a[k++] = r[j++];
          }
      }
}
