package gfgselfplaced.arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {10,15,20,5,14,18,3};
        largestElementInArray(arr);
    }

    private static void largestElementInArray(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            flag = true;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] > arr[i]){
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println(arr[i]);
        }
    }
}
