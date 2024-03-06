import java.util.ArrayList;
import java.util.Iterator;

public class CustomContainer<T> implements Iterable<T> {
    private Object[] array;
    private int currentSize = 0;
    public CustomContainer (int initialCapacity) {
        array = new Object[initialCapacity];
    }
    public CustomContainer () {
        array = new Object[1];
    }
    private void resize () {
        Object [] newArray = new Object[2 * currentSize];
        if (currentSize >= 0)
            System.arraycopy(array, 0, newArray, 0, currentSize);
        array = newArray;
    }
    public int size () {
        return currentSize;
    }
    void add (T element) {
        if (currentSize == array.length)
            resize();
        array[currentSize++] = element;
    }
    T get(int index) {
        if(index >= currentSize)
            throw new IndexOutOfBoundsException("Index " + index + " out of array length(" + currentSize + ")");
        else
            return (T)array[index];
    }
    void remove(int index) {
        if(index >= currentSize)
            throw new IndexOutOfBoundsException("Index " + index + " out of array length(" + currentSize + ")");
        else {
            if (currentSize - 1 > index)
                System.arraycopy(array, index + 1, array, index, currentSize - index);
            currentSize--;
        }
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }
    private class CustomIterator implements Iterator <T>{
        int nextIndex;
        @Override
        public boolean hasNext() {
            return currentSize > nextIndex;
        }
        @Override
        public T next() {
            return (T)array[nextIndex++];
        }
    }
}

