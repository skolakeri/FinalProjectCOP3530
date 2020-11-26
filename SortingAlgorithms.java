import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class SortingAlgorithms {


    public void selectionSort(int arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }


    public void bubbleSort(int arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int swapped = 0;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    public void insertionSort(int arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (key < arr[j] && j >= 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    void mergeSort(int arr[], int l, int m, int r) {
        long startTime = System.nanoTime();
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = 1;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    void quickSort(int array[], int low, int high) {
        long startTime = System.nanoTime();
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    int shellSort(int arr[]){
        long startTime = System.nanoTime();
        int n = arr.length;
        for(int gap = n/2; gap > 0; gap/=2){
            for(int i = gap; i < n; i++){
                int temp = arr[i];
                int j;
                for(j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        return 0;
    }


}
