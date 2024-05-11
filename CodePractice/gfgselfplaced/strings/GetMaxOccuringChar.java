package gfgselfplaced.strings;

import java.util.Arrays;

public class GetMaxOccuringChar {
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String str) {
        int arr[] = new int[256];

        for (int i = 0; i < str.length(); i++) {
//            int temp = arr[str.charAt(i)]++;
//            if (temp > max) {
//                max = temp;
//            }
            arr[str.charAt(i)]++;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        char smallestAmongMax = 256;
        for (int i = 0; i < arr.length; i++) {
            if (arr[str.charAt(i)] == max) {
                if (smallestAmongMax > str.charAt(i)) {
                    smallestAmongMax = str.charAt(i);
                }
            }
        }
        return smallestAmongMax;
    }
}