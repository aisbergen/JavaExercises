public class Main {
    public static void main(String[] args){
        Fibonacci ex = new Fibonacci();
        ex.calculate(5);

    }
}

class Fibonacci{
        public void calculate(int n){
            //Scanner myObj = new Scanner(System.in);
            int F1 = 1;
            int F0 = 0;
            //int n = myObj.nextInt();
            if (n == 0) return;
            if(n==1) return;
            for(int i=2; i<=n; i++){
                int next = F1+F0;    // Add previous two numbers
                F0 = F1;            // Move F0 to next position
                F1 = next;          // Move F1 to next Fibonacci number
            }
            System.out.println(F1);
        }
}

