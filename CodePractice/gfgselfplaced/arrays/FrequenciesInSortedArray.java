package gfgselfplaced.arrays;

public class FrequenciesInSortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 10, 10, 25, 30, 40, 40};
        // 10 3
        // 25 1
        // 30 1
        // 40 1
        frequenciesInSortedArray(arr);
    }

    private static void frequenciesInSortedArray(int[] arr) {
        int frequency = 1;
        int i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[i - 1] ) {
                frequency++;
                i++;
            }
            System.out.println(arr[i - 1] + " " + frequency);
            frequency = 1;
            i++;
        }
        if ((arr[arr.length - 1] != arr[arr.length - 2]) || arr.length == 1) {
            System.out.println(arr[arr.length - 1] + " " + frequency);
        }
    }
}
