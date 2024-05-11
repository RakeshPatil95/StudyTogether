package gfgselfplaced.arrays;

public class MaximumCircularSumSubArray {
    public static void main(String[] args) {
       // int[] arr = {5, -2, 3, 4}; // op - 12 complex n2
        int[] arr = {-3,-2,-3}; // op - 12 complex n2
        maximumCircularSumSubArray(arr);
    }

    private static void maximumCircularSumSubArray(int[] arr) {
        int maxNormal = normalMaxSum(arr);
        if(maxNormal<0){
            System.out.println(maxNormal);
        }
        int currentSum=0;
        for (int i = 0; i < arr.length; i++) {
            currentSum+=arr[i];
            arr[i] = - arr[i];
        }
        int maxCircular = currentSum+normalMaxSum(arr);
        System.out.println(Math.max(maxCircular,maxNormal));
    }

    private static int normalMaxSum(int[] arr) {
        int maxSum = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(arr[i] + maxSum, arr[i]);
            result = Math.max(result, maxSum);
        }
        return result;
    }

//    private static void maximumCircularSumSubArray(int[] arr) {
//        int result =arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            int currentSum = arr[i];
//            int currentMaxSum = arr[i];
//            for (int j = 1; j < arr.length; j++) {
//                int index = (i + j) % arr.length;
//                currentSum += arr[index];
//                currentMaxSum = Math.max(currentSum, currentMaxSum);
//            }
//            result = Math.max(currentMaxSum,result);
//        }
//        System.out.println(result);
//    }

}
