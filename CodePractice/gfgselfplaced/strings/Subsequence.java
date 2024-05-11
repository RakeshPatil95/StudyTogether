package gfgselfplaced.strings;

public class Subsequence {
    public static void main(String[] args) {
        String a = "AXY";
        String b = "YADXCP";
        System.out.println(isSubSequence(a, b));
    }

    //Function to check if a string is subsequence of other string.
    public static boolean isSubSequence(String A, String B) {
//        int lastPosition = 0;
//        int count = 0;
//        if (A.length() > B.length()) {
//            return false;
//        }
//        for (int i = 0; i < A.length(); i++) {
//            for (int j = lastPosition; j < B.length(); j++) {
//                if (A.charAt(i) == B.charAt(j)) {
//                    lastPosition = j+1;
//                    count++;
//                    break;
//                }
//            }
//        }
//        if (count == A.length()) {
//            return true;
//        } else {
//            return false;
//        }


        int idx = 0;
        for(int i=0;i<B.length();i++){
            if(A.charAt(idx) == B.charAt(i)){
                idx++;
            }
        }
        if(idx == A.length()){
            return true;
        }else{
            return false;
        }
    }
}
