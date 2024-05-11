package gfgselfplaced.arrays;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        containsNearbyDuplicate(arr,3);
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i] == nums[j]){
                    if(Math.abs(i-j) >= k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
