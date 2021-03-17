package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TQSstackTest {

    private TQSstack<String> emptyStack;
    private TQSstack<String> stack4elements;

    // Antes de cada um dos testes
    @BeforeEach
    void setUp() {
        emptyStack = new TQSstack<>();

        stack4elements = new TQSstack<>();
        stack4elements.push("blue");
        stack4elements.push("red");
        stack4elements.push("green");
        stack4elements.push("yellow");
    }

    // Depois de cada um dos testes
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @DisplayName("A stack is empty on construction")
    @Test
    void isEmpty() {
        TQSstack<String> stack = new TQSstack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void size() {
        TQSstack<String> stack = new TQSstack<>();
        assertEquals(stack.size(), 0, "empty stack reports non-zero size");
    }

    @Test
    void push() {
        emptyStack.push("one");
        assertFalse(emptyStack.isEmpty());
    }

    @Test
    void pop() {
        assertTrue(stack4elements.pop() == "yellow", () -> "Non empty stack reporting empty");
    }

    @DisplayName("A stack has size 0 on construction")
    @Test
    void sizeOnConstruction() {
        TQSstack<String> teststack = new TQSstack<>();
        assertEquals(0, teststack.size());
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    void push4elements() {
        emptyStack.push("blue");
        emptyStack.push("red");
        emptyStack.push("green");
        emptyStack.push("yellow");

        assertEquals(4, emptyStack.size());
    }

    @DisplayName("If one pushes x then pops, the value popped is x.")
    @Test
    void pushThenPop() {
        emptyStack.push("x");
        assertEquals("x", emptyStack.pop());
    }

    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    void pushThenPeekSizeCheck() {
        emptyStack.push("x");
        int size = emptyStack.size();

        assertEquals("x", emptyStack.peek());
        assertEquals(size, emptyStack.size());
    }

    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    void maxPopsEmpty() {
        for (int i = 0; i < 4; i++){
            stack4elements.pop();
        }
        assertTrue(stack4elements.isEmpty());
        assertEquals(0, stack4elements.size());
    }

    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    @Test
    void popEmptyStack() {
        Exception e = assertThrows(NoSuchElementException.class, () -> emptyStack.pop());
    }

    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    void peekEmpty() {
        Exception e = assertThrows(NoSuchElementException.class, () -> emptyStack.peek());
    }

    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    @Test
    void pushToFull() {
        TQSstack<String> teststack = new TQSstack<>(2);
        teststack.push("one");
        teststack.push("two");
        Exception e = assertThrows(IllegalStateException.class, () -> teststack.push("three"));
    }
}