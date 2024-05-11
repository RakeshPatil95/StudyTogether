package gfgselfplaced.arrays;

public class SequenceSumCalculator {

    public static long getSequenceSum(int i, int j, int k) {
        long sum = 0;

        // Sum increasing sequence from i to j
        for (int n = i; n <= j; n++) {
            sum += n;
        }

        // Sum decreasing sequence from j-1 to k
        for (int m = j - 1; m >= k; m--) {
            sum += m;
        }

        return sum;
    }

    public static void main(String[] args) {
        int i = 5;
        int j = 9;
        int k = 6;

        long result = getSequenceSum(i, j, k);
        System.out.println("Sum: " + result);
    }
}

