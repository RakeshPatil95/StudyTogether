package gfgselfplaced.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,4};
        System.out.println( containsDuplicate(arr));
        //System.out.println( containsDuplicate1(arr));


    }

    private static boolean containsDuplicate1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        Map map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i],1);
            }
        }
        return false;
    }
}
