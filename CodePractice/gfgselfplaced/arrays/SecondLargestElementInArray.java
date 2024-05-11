package gfgselfplaced.arrays;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 5, 14, 18, 3};
        secondLargestElementInArray(arr);
    }

    private static void secondLargestElementInArray(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }else{
                if (arr[i] > secondLargest) {
                    secondLargest = arr[i];
                }
            }

        }
        System.out.println(largest + " "+secondLargest);
    }
}
