import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.*;

public class DoublelyLinkedListTest {
    private DoublelyLinkedList<Integer> list;


    @Test
    public void testAppend() {
        list = new DoublelyLinkedList<Integer>();
        for(int i = 0; i < 5; i++) {
            list.append(i);
        }
        assertEquals("Head does not equal", Integer.valueOf(0), list.getHead());
        assertEquals("Tail does not equal", Integer.valueOf(4), list.getTail());
        assertEquals("Incorrect Size", 5, list.getSize());
        //list.printLinkedList();
    }

    @Test
    public void testPrepend() {
        list = new DoublelyLinkedList<Integer>();
        for(int i = 0; i < 5; i++) {
            list.append(i);
        }
        list.prepend(5);
        list.append(100);
        assertEquals("Head does not equal", Integer.valueOf(5), list.getHead());
        assertEquals("Tail does not equal", Integer.valueOf(100), list.getTail());
        assertEquals("Incorrect Size", 6, list.getSize());
        //list.printLinkedList();
        list.printReverseLinkList();
    }
}

