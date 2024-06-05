public class Main {
    public static void main(String[] args) {
        int n = 40;
        long start = System.nanoTime();
        Fibonacci fib = new Fibonacci();
        fib.fibonacci(n);
        fib.printFibonacci(n);
        long end = System.nanoTime();
        long execution = end - start;
        System.out.println();
        System.out.println("Execution time: " + (double) execution / 1000000000 + " seconds");
    }
}
