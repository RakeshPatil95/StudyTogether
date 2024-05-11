package gfgselfplaced.arrays;

public class MaximumLengthOfEvenOddSubarray {
    public static void main(String[] args) {
        // int[] arr = {5, 10, 20, 6, 3, 8}; // op 3 compl - n2
        int[] arr = {5, 10, 20, 6, 3, 8}; // op 3 compl - n
        maximumLengthOfEvenOddSubarray(arr);
    }

    private static void maximumLengthOfEvenOddSubarray(int[] arr) {
        int result = 1;
        int currentElement = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                currentElement++;
                result = Math.max(result, currentElement);
            } else {
                currentElement = 1;
            }
        }
        System.out.println(result);
    }

//    private static void maximumLengthOfEvenOddSubarray(int[] arr) {
//        int result = 1;
//        for (int i = 0; i < arr.length; i++) {
//            int currentElement = 1;
//            for (int j = i + 1; j < arr.length; j++) {
//                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) || (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0)) {
//                    currentElement++;
//                } else {
//                    break;
//                }
//            }
//            result = Math.max(result, currentElement);
//        }
//        System.out.println(result);
//    }
}
