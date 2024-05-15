public class Fibonacci {

    public long[] cache = new long[100];

    public long fibonacci(int n) {
        if(n <= 1) return n;
        if(cache[n] != 0) return cache[n];

        cache[n] = fibonacci(n-1) + fibonacci(n-2);
        return cache[n];
    }

    public void printFibonacci(int n) {
        for(int i = 0; i <= n; i++) {
            System.out.print(this.cache[i] + " ");
        }
    }

}
