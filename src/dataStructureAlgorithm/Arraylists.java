package dataStructureAlgorithm;

public class Arraylists {
    private int count;
    private String[] elements;

    public Arraylists(int size){
        elements = new String[size];
    }
    public boolean isEmpty(){
        return count == 0;
    }

    public void add(String element){
        if(count == elements.length) expand();
        elements[count++] = element;
    }
    public void expand(){
       elements = new String[count *2];
    }

    public String remove(int removeIndex){
        count--;
        String removedElement = elements[removeIndex];
        for(int index = removeIndex; index < count; index++ ){
            elements[index] = elements[index+1];
        }
        return removedElement;
    }
    public void addElement(int addIndex, String element){
        if(count == elements.length) expand();
        for(int index = count; index > addIndex; index--){
            elements[index] = elements[index-1];
        }
        elements[addIndex] = element;
    }

    public void addFirst(String element){
        addElement(0, element );
    }

    public String get(int index){
        return elements[index];
    }

    public String getFirst(){
        return elements[0];
    }

    public String getLast(){
        return elements[count-1];
    }



}
