import java.util.Iterator;

class FibonacciSequence implements Sequence {
    private int count;

    public FibonacciSequence(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(count);
    }
}
