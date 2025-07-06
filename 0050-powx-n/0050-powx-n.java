class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            return calculatePower(x, -(long)n);
        }
        return calculatePower(x,n);
        
    }

    private double calculatePower(double x, long n){
        //recursion
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }

        double halfPower = calculatePower(x, n/2); //x^(n/2)

        if (n % 2 == 0) {
            // If n is even: x^n = (x^(n/2)) * (x^(n/2))
            return halfPower * halfPower;
        } else {
            // If n is odd: x^n = (x^(n/2)) * (x^(n/2)) * x
            return halfPower * halfPower * x;
        }
    }
}