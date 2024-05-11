package gfgselfplaced.arrays;

public class Main {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPythagoreanPrime(int n) {
        return isPrime(n) && (n - 1) % 4 == 0;
    }

    public static void main(String[] args) {
        int number = 188585; // Change this to test other numbers
        if (isPythagoreanPrime(number)) {
            System.out.println(number + " is a Pythagorean prime.");
        } else {
            System.out.println(number + " is not a Pythagorean prime.");
        }
    }
}
