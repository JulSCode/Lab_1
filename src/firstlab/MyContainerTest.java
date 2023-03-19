package firstlab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyContainerTest {
    /**
     * value of class
     */
    MyContainer mc;
    /**
     * template for tests
     */
    @BeforeEach
    void prepareData() {
        mc = new MyContainer();
    }
    /**
     * test method
     */
    @Test
    void testAddToHead() {
        mc.addToHead(111);
        assertEquals(mc.getFirst(), 111);
    }

    @Test
    void testAddToTail() {
        mc.addToTail(111);
        assertEquals(mc.getLast(), 111);
    }

    @Test
    void testAddToIndex() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        mc.addToIndex(1,111);
        assertEquals(mc.get(1), 111);
    }

    @Test
    void testGetSize() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        assertEquals(mc.getSize(), 4);
    }

    @Test
    void testGetFirst() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        assertEquals(mc.getFirst(), 0);
    }

    @Test
    void testGetLast() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        assertEquals(mc.getLast(), 3);
    }

    @Test
    void testGet() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        assertEquals(mc.get(1), 1);
    }

    @Test
    void testRemoveFirst() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        mc.removeFirst();
        assertEquals(mc.getFirst(), 1);
    }

    @Test
    void testRemoveLast() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        mc.removeLast();
        assertEquals(mc.getLast(), 2);
    }

    @Test
    void testRemove() {
        for (int i = 0; i<=3; i++)
            mc.addToTail(i);
        mc.remove(1);
        assertEquals(mc.get(1), 2);
    }

    @Test
    void testRemoveElements() {
        for (int i = 0; i<=5; i++)
            mc.addToTail(i%2);
        mc.removeElements(1);
        assertEquals(mc.getSize(), 3);
        for (int i = 0; i<mc.getSize(); i++)
            assertEquals(mc.get(i), 0);
    }

    @Test
    void testFirstIndexOf() {
        for (int i = 0; i<=5; i++)
            mc.addToTail(i%3);
        assertEquals(mc.firstIndexOf(1), 1);
    }

    @Test
    void testLastIndexOf() {
        for (int i = 0; i<=5; i++)
            mc.addToTail(i%3);
        assertEquals(mc.lastIndexOf(1), 4);
    }

    @Test
    void testClear() {
        for (int i = 0; i<=5; i++)
            mc.addToTail(i);
        mc.clear();
        assertEquals(mc.getFirst(), null);
        assertEquals(mc.getLast(), null);
        assertEquals(mc.getSize(), 0);
    }

    @Test
    void testToArray() {
        for (int i = 0; i<=5; i++)
            mc.addToTail(i);

        int[]array = new int[mc.getSize()];
        array = mc.toArray();

        for (int i = 0; i< mc.getSize(); i++)
            assertEquals(mc.get(i), array[i]);
    }
}