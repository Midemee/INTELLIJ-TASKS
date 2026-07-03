package dataStructureAlgorithm;

public class LinkedListOperation {
    private int size;
    private final String[] elements;

    public LinkedListOperation(int capacity) {
        elements = new String[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(String element) {
        if (isFull()) throw new IllegalArgumentException("List is full");
        elements[size++] = element;
    }

    public void addFirst(String element) {
        if (isFull()) throw new IllegalArgumentException("List is full");
        for (int i = size; i > 0; i--)
            elements[i] = elements[i - 1];
        elements[0] = element;
        size++;
    }

    public String getFirst() {
        if (isEmpty()) throw new IllegalArgumentException("List is empty");
        return elements[0];
    }

    public String getLast() {
        if (isEmpty()) throw new IllegalArgumentException("List is empty");
        return elements[size - 1];
    }

    public void deleteFirst() {
        if (isEmpty()) throw new IllegalArgumentException("List is empty");
        for (int i = 0; i < size - 1; i++)
            elements[i] = elements[i + 1];
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) throw new IllegalArgumentException("List is empty");
        size--;
    }

    public boolean contains(String element) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(element)) return true;
        return false;
    }

    public int size() {
        return size;
    }

    public String[] toArray() {
        String[] array = new String[size];
        for (int i = 0; i < size; i++)
            array[i] = elements[i];
        return array;
    }

    private boolean isFull() {
        return size == elements.length;
    }
}
