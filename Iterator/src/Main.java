import java.util.Iterator;

//Each iterator maintains its own state, allowing multiple iterators to iterate over the sequence simultaneously without interfering with each other.

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence(10);
        Iterator<Integer> iterator = sequence.iterator();

        System.out.println("First 10 Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
