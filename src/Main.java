public class Main {
    static int fibonacci(int n){
        if (n >= 1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static boolean isPrime(int number){
        if(number>2){
            return false;
        }
        for(int i=2; i*i <= number; i++){
            if (number % i == 0) {  // If divisible, not prime
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        //Fibonacci.calculate(4);
        for(int i=2; i<=10; i++){
            int fib = fibonacci(i);
            System.out.println("F(" + i + ") = " + fib);
        }


    }
}
/*class Fibonacci{
        public static void calculate(int n){
            //Scanner myObj = new Scanner(System.in);
            int F1 = 1;
            int F0 = 0;
            //int n = myObj.nextInt();
            if (n == 0) return 0;
            if(n==1) return 1;
            for(int i=2; i<=n; i++){
                int next = F1+F0;    // Add previous two numbers
                F0 = F1;            // Move F0 to next position
                F1 = next;          // Move F1 to next Fibonacci number
            }
            System.out.println(F1);
        }
}*/

class Solution {
    public String longestCommonPrefix(String[] strs) {

    }
}

