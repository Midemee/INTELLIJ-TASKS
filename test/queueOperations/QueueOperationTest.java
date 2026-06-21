package queueOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueOperationTest {
    private QueueOperation queue;
    @BeforeEach
    public void setUp(){
        queue = new QueueOperation(7);
    }
    @Test
    public void testThatNewQueueisEmpty(){
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testThatAfterIEnqueuedOneElementQueueIsNotEmpty(){
        queue.enqueue("Aramide");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testThatIEnqueuedOneElementAndDequeuedOneElementQueueIsEmptyAgain(){
        queue.enqueue("Aramide");
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testThatIEnqueueTwoElementsThenDequeueOneQueueIsNotEmpty() {
        queue.enqueue("Ghost");
        queue.enqueue("Patrick");

        queue.dequeue();
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testThatDequeueGivesCorrectElement() {
        queue.enqueue("Mide");
        queue.enqueue("Tosin");

        assertEquals("Mide", queue.dequeue());
    }

    @Test
    public void testThatDequeueGivesCorrectElementInFifoOrder() {
        queue.enqueue("Tosin");
        queue.enqueue("Mide");

        assertEquals("Tosin", queue.dequeue());
        assertEquals("Mide", queue.dequeue());
    }

    @Test
    public void testThatDequeuingAnEmptyQueueThrowsExceptionError() {
        queue.enqueue("Mide");
        queue.enqueue("Tosin");

        queue.dequeue();
        queue.dequeue();
        assertThrows(IllegalArgumentException.class, () -> queue.dequeue());
    }

    @Test
    public void testThatEnqueueingMoreThanQueueSizeThrowsExceptionError() {
        QueueOperation queue = new QueueOperation(3);

        queue.enqueue("Mide");
        queue.enqueue("David");
        queue.enqueue("Tosin");

        assertThrows(IllegalArgumentException.class, () -> queue.enqueue("Mercy"));
    }

    @Test
    public void testThatPeekReturnsTheFrontElementWithoutRemoving() {
        queue.enqueue("Bolu");
        queue.enqueue("Aramide");

        assertEquals("Bolu", queue.peek());
    }

}
