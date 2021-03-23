public class SortingAlgo {
    private int[] arr;
    private int size;
    private long time;
    private long compare;

    public void setArr(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }


    public long getTime(){
        return this.time;
    }

    public long getCompare(){
        return this.compare;
    }

    public int[] returnMergeSort(){
        this.compare = 0;
        long startTime = System.nanoTime();
        mergeSort(this.arr, this.size);
        long endTime = System.nanoTime();
        this.time = endTime - startTime;
        return this.arr;
    }

    public int[] returnInsertionSort(){
        this.compare = 0;
        long startTime = System.nanoTime();
        insertionSort();
        long endTime = System.nanoTime();
        this.time = endTime - startTime;
        return this.arr;
    }

    private int[] insertionSort(){
        for(int i =1;i<this.size;i++){
            for(int j=i;j>0;j--){
                this.compare += 1;
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

    private void mergeSort(int[] a, int n) {
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

    private void merge(int[] a, int[] l, int[] r, int left, int right) {
       
          int i = 0, j = 0, k = 0;
          while (i < left && j < right) {
              //1 comparism
              this.compare += 1;
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
