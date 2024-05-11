package gfgselfplaced.arrays;

public class MaxIndexDiff {
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) {
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] <= a[j]) {
                    if(j-i > maxDiff){
                        maxDiff = j-1;
                    }
                }
            }
        }
        return maxDiff;
    }
}
