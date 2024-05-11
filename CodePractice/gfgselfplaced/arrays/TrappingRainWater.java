package gfgselfplaced.arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        // int arr[] = {3,0,1,2,5};
        // int arr[] = {1,2,3,4};
        // int arr[] = {5,4,3,2,1};
        int arr[] = {5, 0, 6, 2, 3};
        trappingRainWater(arr);
    }

    // Order of N solution:
    private static void trappingRainWater(int[] arr) {
        // pre stores the left max and right max for each element in array in seperate 2 arrays
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int result = 0;

        leftMax[0] = arr[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int j = arr.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        }
        // arr array - 5,0,6,2,3
        // left array - 5,5,6,6,6
        // right array - 6,6,6,3,3

        for (int k = 1; k < arr.length - 1; k++) {
            result += Math.min(leftMax[k], rightMax[k]) - arr[k];
        }
        System.out.println(result);
    }

//    private static void trappingRainWater(int[] arr) {
//        int leftMax = 0;
//        int rightMax = 0;
//        int result = 0;
//        for (int i = 1; i < arr.length-1 ; i++) {
//            leftMax=arr[i];
//            for (int j = 0; j < i ; j++) {
//               leftMax = Math.max(arr[j],leftMax);
//            }
//            rightMax=arr[i];
//            for (int k = i+1; k < arr.length ; k++) {
//                rightMax = Math.max(arr[k],rightMax);
//            }
//            result += Math.min(leftMax,rightMax) - arr[i];
//        }
//        System.out.println(result);
//    }
}
