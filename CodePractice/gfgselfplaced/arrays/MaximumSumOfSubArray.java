package gfgselfplaced.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaximumSumOfSubArray {
    public static void main(String[] args) {
        //  int[] arr = {1,-2,3,-1,2}; //op - 4 -  complx n2
        int[] arr = {-5, 1, -2, 3, -1, 2, -2}; //op - 4 -  complx n
        maximumSumOfSubArray(arr);
    }

    private static void maximumSumOfSubArray(int[] arr) {
        int maxSum = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(arr[i] + maxSum, arr[i]);
            result = Math.max(result, maxSum);
        }
        // Arrays.stream(maxSum).forEach(System.out::println);
        System.out.println(result);
    }

//    private static void maximumSumOfSubArray(int[] arr) {
//        int result=0;
//        for (int i = 0; i < arr.length; i++) {
//            int currentSum=0;
//            for (int j = i; j < arr.length; j++) {
//                currentSum += arr[j];
//                result = Math.max(result,currentSum);
//            }
//        }
//        System.out.println(result);
//    }
}
