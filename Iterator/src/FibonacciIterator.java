import java.util.Iterator;

class FibonacciIterator implements Iterator<Integer> {
    private int count;
    private int current = 1;
    private int previous = 0;

    public FibonacciIterator(int count) {
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return count > 0;
    }
    @Override
    public Integer next() {
        int result = current;
        int temp = current;
        current += previous;
        previous = temp;
        count--;
        return result;
    }
}