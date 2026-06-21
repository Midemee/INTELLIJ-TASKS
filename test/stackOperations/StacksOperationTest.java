package stackOperations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StacksOperationTest {

    private StacksOperation stack;

    @BeforeEach
    void setUp() {
        stack = new StacksOperation(7);
    }

    @Test
    public void testThatNewStackisEmptyTest() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatAfterIPushOneElementStackisNotEmptyTest() {
        stack.push("Aramide");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testThatIPushOneElementThenPopOneElementStackIsEmptyAgain(){
        stack.push("Aramide");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatIPushOneElementThenPopOneElementStackIsNotEmpty() {
        stack.push("Ghost");
        stack.push("Patrick");

        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testThatPopGivesCorrectElement() {
        stack.push("Mide");
        stack.push("Tosin");

        assertEquals("Tosin", stack.pop());
    }

    @Test
    public void testThatPopGivesCorrectElementInLifoOrder() {
        stack.push("Tosin");
        stack.push("Mide");

        assertEquals("Mide", stack.pop());
        assertEquals("Tosin", stack.pop());
    }

    @Test
    public void testThatPoppingAnEmptyStackThrowsExceptionError() {
        stack.push("Mide");
        stack.push("Tosin");

        stack.pop();
        stack.pop();
        assertThrows(IllegalArgumentException.class, () -> stack.pop());
    }

    @Test
    public void testThatIPushMoreElementsMoreThanStackSizeThrowsExceptionError() {
        StacksOperation stack = new StacksOperation(5);

        stack.push("Mide");
        stack.push("David");
        stack.push("Tosin");
        stack.push("Mercy");
        stack.push("Steve");

        assertThrows(IllegalArgumentException.class, () -> stack.push("Jacob"));
    }

    @Test
    public void testThatPeekReturnsTheTopElementWithoutRemoving() {
        stack.push("Bolu");
        stack.push("Aramide");

        assertEquals("Aramide", stack.peek());
    }
}


