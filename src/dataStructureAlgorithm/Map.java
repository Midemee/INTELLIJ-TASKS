package dataStructureAlgorithm;

public class Map {

    private int size;

    private String[][] elements = new String[10][2];

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {

        return size;
    }

    public void push(String key, String value) {
        elements[size][0] = key;
        elements[size][1] = value;
        size++;
    }

    public String get(String key) {
        int index = indexOf(key);
        if (index < 0) return null;
        return elements[index][1];
        //return index < 0 ? null : elements[index][1];
    }

    public String remove(String key) {
        int index = indexOf(key);
        if (index < 0) return null;

        String removedValue = elements[index][1];
        size--;
        shiftElementLeft(index);

        return removedValue;
    }

    private int indexOf(String key) {
        for (int index = 0; index < size; index++) {
            if (key.equals(elements[index][0])) return index;
        }
        return -1;
    }

    private void shiftElementLeft(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
    }
}