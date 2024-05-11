package leetCode;

public class PalindromNumber {
    public static void main(String[] args) {
        int num = 11;
        System.out.println(palindromNumber(num));
    }

//    private static boolean palindromNumber(int num) {
//        String stringNum = Integer.toString(num);
//        int end = stringNum.length()-1;
//        if(num < 0 ){
//            return false;
//        }
//        if(num <=9 && num >=0){
//            return true;
//        }
//        for (int i = 0; i < stringNum.length() ; i++) {
//            if(i == end || end  < i){
//                return true;
//            }
//            if(stringNum.charAt(i) == stringNum.charAt(end)){
//                end--;
//            }
//            else {
//                return false;
//            }
//        }
//       return false;
//    }
    private static boolean palindromNumber(int num) {
        int x = num;
        int temp = 0;
        while (x > 0){
            int value;
            temp *= 10;
            value = x%10;
            temp += value;
            x /= 10;
        }
        if( temp == x) {
            return true;
        }
        return false;
    }
}
