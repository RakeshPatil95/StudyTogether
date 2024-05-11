package gfgselfplaced.arrays;

public class MaximumDifference {
// Max value of arr[j] - arr[i] such that j>i;
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 5, 14, 18, 3};
        // op - 13
        maximumDifference(arr);
    }

// nieve sol 2 nested for loops
    private static void maximumDifference(int[] arr) {
        int max_diff = arr[1]-arr[0];
        int current_min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max_diff = Math.max(max_diff,arr[i]-current_min);
            current_min = Math.min(arr[i],current_min);
        }
        System.out.println(max_diff);
    }
}
