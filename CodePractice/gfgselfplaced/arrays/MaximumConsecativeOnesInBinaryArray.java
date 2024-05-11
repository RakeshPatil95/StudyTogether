package gfgselfplaced.arrays;

public class MaximumConsecativeOnesInBinaryArray {
    public static void main(String[] args) {
        boolean[] arr = {true, false, true, true, true, true, false, true, true};
        maximumConsecativeOnesInBinaryArray(arr);
    }

    private static void maximumConsecativeOnesInBinaryArray(boolean[] arr) {
        int result = 0;
        int counter =0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == false){
                counter = 0;
            }else{
                counter++;
                result = Math.max(counter,result);
            }
        }
        System.out.println(result);
    }
}
