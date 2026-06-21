package queueOperations;

public class QueueOperation {
private int front;
private int back;
private int count;
private final String[] elements;

public QueueOperation(int size){
    elements = new String[size];
}

public boolean isEmpty(){
    return count == 0;
}

public void enqueue(String element){
    if(isFull()) throw new IllegalArgumentException("Queue is full");
    elements[back++] = element;
    count++;
}

public boolean isFull(){
    return count == elements.length;
}

public String dequeue(){
    if(isEmpty()) throw new IllegalArgumentException("Queue is empty");
    count--;
    return elements[front++];
}

public String peek(){
    return elements[front];
}

}
