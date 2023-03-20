package datastr;

public class MyHeap <T>{
    private T[] elements;
    private final int DEFAULT_ARRAY_SIZE = 5;
    private int arraySize = DEFAULT_ARRAY_SIZE;
    private int elementCount = 0;

    public MyHeap()
    {
        elements = (T[]) new Object[arraySize];
    }
    public MyHeap(int inputArraySize) {
        if(inputArraySize > 0) {
            arraySize = inputArraySize;
        }
        elements = (T[]) new Object[arraySize];
    }
    public boolean isFull() {
        return (elementCount == arraySize);
    }
    public boolean isEmpty()
    {
        return (elementCount == 0);
    }
    public int howManyElements() {
        return elementCount;
    }
    private void increaseHeap() {
        int newArraySize = (arraySize > 100)? (int)(arraySize*1.5) : arraySize*2;
        T[] newElements = (T[]) new Object[newArraySize];
        //elementu kopesana
        if (arraySize >= 0) System.arraycopy(elements, 0, newElements, 0, arraySize);
        elements = newElements;
        arraySize = newArraySize;
    }



}
