package gfgselfplaced.strings;

import java.util.Arrays;

public class SmallestString {

    public static String smallestString(String[] A) {
        StringBuilder sb = new StringBuilder();

        // Iterate through each character position across all strings
        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            char minChar = Character.MAX_VALUE;
            for (int j = 0; j < str.length(); j++) {
                minChar = (char) Math.min(str.charAt(j),minChar);
            }
            sb.append(minChar);
        }
        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);
        sb.setLength(0);
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] A = {"xxx", "vvv", "zzz"};
        System.out.println(smallestString(A));
    }
}

