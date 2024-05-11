package gfgselfplaced.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindString {

    public static String findString(String s, String p) {
        // Create a map to store the character mappings.
        Map<Character, Character> charMap = new HashMap<>();
        // The loop should run for the length of 'p', not 's'.
        for (int i = 0; i < p.length(); i++) {
            charMap.put(p.charAt(i), s.charAt(i));
        }

        // Type the string p on the typewriter and return the output.
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            output.append(charMap.get(p.charAt(i)));
        }

        return output.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "qwertyuiop";
        String p = "cba";
        String output = findString(s, p);
        System.out.println(output);  // Expected output should be defined based on the mapping logic.

        String s2 = "abcdefghijklmnopqrstuvwxyz";
        String p2 = "abracadabra";
        String output2 = findString(s2, p2);
        System.out.println(output2);  // Expected output should be defined based on the mapping logic.
    }
}
