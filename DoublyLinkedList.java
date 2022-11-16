import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;// head==null
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null)
            return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null" + "\n");
    }

    public void displayBackward() {
        if (tail == null)
            return;
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.print("null" + "\n");
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail)
            tail = null;
        else
            head.next.previous = null;
        head = head.next;
        temp.next = null;
        length--;

        return temp;
    }

    public ListNode deleteLastNode(){
        if(isEmpty()) throw new NoSuchElementException();
        ListNode temp = tail;
        if(head == tail) head = null;
        else tail.previous.next = null;

        tail = tail.previous;
        temp.previous = null;

        return temp;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert at first;
        // dll.insertFirst(1);
        // dll.insertFirst(2);
        // dll.insertFirst(3);
        // dll.insertFirst(4);
        // dll.displayForward();
        // dll.displayBackward();

        // Insert at Last;
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(3);
        dll.insertLast(4);
        dll.displayForward();
        // dll.displayBackward();

        // Delete at first;
        // System.out.println(dll.deleteFirst().data);
        // System.out.println(dll.deleteFirst().data);
        // System.out.println(dll.deleteFirst().data); 
        // System.out.println(dll.deleteFirst().data); 
        // System.out.println(dll.deleteFirst().data); 
        // dll.displayForward();
        // dll.displayBackward();

        // Delete at last
        // System.out.println(dll.deleteLastNode().data);
        // System.out.println(dll.deleteLastNode().data);
        // System.out.println(dll.deleteLastNode().data);
        // // System.out.println(dll.deleteLastNode().data);
        // dll.displayForward();

    }

}