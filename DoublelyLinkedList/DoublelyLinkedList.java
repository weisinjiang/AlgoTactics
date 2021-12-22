import java.util.ArrayList;

// Doubly Linked List that can store a generic type 
public class DoublelyLinkedList<T> {

    DoublelyNode head;
    DoublelyNode tail;
    int size;

    private class DoublelyNode {
        DoublelyNode next;
        DoublelyNode prev;
        T data; 

        DoublelyNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }        

        T getData() {
            return this.data;
        }
    }

    DoublelyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add to the end of the linkedlist 
    public void append(T data) {
        DoublelyNode newNode = new DoublelyNode(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.next = newNode; // curr tail's next is new node
            newNode.prev = this.tail; // new node's prev is the curr tail
            this.tail = newNode; // update tail ref
        }
        this.size++;
    }

    public void prepend(T data) {
        DoublelyNode newNode = new DoublelyNode(data);
        newNode.next = this.head; // new node's next is the curr head
        this.head.prev = newNode; // curr head's prev is the new node
        this.head = newNode; // new head ref 
    }

    public T getHead() {
        return this.head.data;
    }

    public T getTail() {
        return this.tail.data;
    }

    public int getSize() {
        return this.size;
    }

    public void printLinkedList() {
      DoublelyNode currNode = this.head;
      
      while(currNode != null) {
          System.out.println(currNode.data + "\n");
          currNode = currNode.next;
      }
    }

    public void printReverseLinkList() {
        DoublelyNode currNode = this.tail;
        while(currNode != null) {
            System.out.println(currNode.data + "\n");
            currNode = currNode.prev;
        }

    }

    
}

