package gfgselfplaced.arrays;

public class StockBuyAndSell1 {
    public static void main(String[] args) {
       // int arr[] = {1, 5, 3, 8, 12}; 13
        // int arr[] = {10,20,30,40}; 30
         int arr[] = {40,30,20,10}; //0
        stockBuyAndSell1(arr);
    }

    private static void stockBuyAndSell1(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                profit+= (arr[i]-arr[i-1]);
            }
        }
        System.out.println(profit);
    }
}
