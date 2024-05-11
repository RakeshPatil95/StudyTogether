package gfgselfplaced.arrays;

public class LocalMinimumMaximum {
    public static void main(String[] args) {
        int arr[] = {2,-1,0,-1,4};
        localMinimumMaximum(arr);
//        localMinimumMaximum(new int[]{1, 1, 1, 1, 1, 1}); // All elements equal
//        localMinimumMaximum(new int[]{1, 2, 1, 2, 1, 2}); // Alternating ascending and descending
//        localMinimumMaximum(new int[]{1, 2, 3, 4, 5}); // Ascending order
//        localMinimumMaximum(new int[]{5, 4, 3, 2, 1}); // Descending order
//        localMinimumMaximum(new int[]{1}); // Single element
//        localMinimumMaximum(new int[]{1, 2}); // Two elements, one larger than the other
//        localMinimumMaximum(new int[]{2, 1}); // Two elements, one smaller than the other
//        localMinimumMaximum(new int[]{1, 3, 2}); // Three elements, forming a peak at the middle
//        localMinimumMaximum(new int[]{3, 1, 2}); // Three elements, forming a valley at the middle
//        localMinimumMaximum(new int[]{1, 3, 1, 2, 1, 3, 1});
    }

    private static void localMinimumMaximum(int[] arr) {
        int count=0;
        for (int i = 1; i < arr.length-1; i++) {
            if((arr[i-1] < arr[i] && arr[i+1] < arr[i]) || (arr[i-1] > arr[i] && arr[i+1] > arr[i])){
                count++;
            }
        }
        System.out.println(count);
    }
}
