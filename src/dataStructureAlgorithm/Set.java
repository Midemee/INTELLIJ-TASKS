package dataStructureAlgorithm;

public class Set {
    private int size;

    private String[] elements = new String[10];

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() { return size; }

    public boolean add(String element) {
        if (contains(element)) return false;
        elements[size++] = element;
        return true;
    }

    public boolean remove(String element) {
        int index = indexOf(element);

        boolean elementNotFound = index < 0;
        if (elementNotFound) return false;

        size--;
        shiftElementLeft(index);
        return true;
    }

    public boolean contains(String element) {
        return indexOf(element) >= 0;
    }

    private int indexOf(String element) {
        for (int index = 0; index < size; index++) {
            if (element.equals(elements[index]))
                return index;
        }
        return -1;
    }

    private void shiftElementLeft(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
    }
}