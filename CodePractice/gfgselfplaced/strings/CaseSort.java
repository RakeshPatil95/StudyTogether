package gfgselfplaced.strings;

import java.util.Arrays;

public class CaseSort {
    public static void main(String[] args) {
        System.out.println(caseSort("defRTSersUXI"));
    }
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        int arr1[] = new int[str.length()];
        int arr2[] = new int[str.length()];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
                arr1[i]++;
                sb1.append(str.charAt(i));
            } else {
                arr2[i]++;
                sb2.append(str.charAt(i));
            }
        }

        Arrays.stream(arr1).forEach(System.out::print);
        System.out.println(sb1);
        Arrays.stream(arr2).forEach(System.out::print);
        System.out.println(sb2);
        return null;
    }
}
