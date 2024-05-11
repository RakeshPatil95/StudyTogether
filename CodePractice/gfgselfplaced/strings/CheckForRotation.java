package gfgselfplaced.strings;

public class CheckForRotation {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        System.out.println(checkForRotation(s1, s2));
    }

    private static boolean checkForRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return ((s1 + s2).contains(s2));
    }
}
