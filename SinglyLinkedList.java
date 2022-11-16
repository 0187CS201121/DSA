public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        if (head == null)
            System.out.println("null");
        ListNode current = head;
        while (null != current) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null" + "\n");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int possition, int value) {
        ListNode node = new ListNode(value);

        // 2 --> 4 --> 3 --> 5 --> 1 --> null;
        // prviouos=4
        // current = 3

        if (possition == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < possition - 1) {
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public ListNode deleteAtFirst() {
        if (head == null)
            return null;

        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteAtLast() {
        if (head == null) {
            return head;
        }
        if(head.next == null){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public void delete(int possition) {
        // 2 --> 4 --> 3 --> 5 --> 1 --> null;
        if (possition == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < possition - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public boolean find(ListNode head, int searchKey) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) {
                System.out.println(current.data);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reverse linkedList

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // LisNode middle node
    public ListNode getMiddleNode() {
        if (head == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    // find nth node from the end of the list;

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0)
            throw new IllegalArgumentException("Invalid Value n = " + n);
        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count = 0;

        while (count < n) {
            if (refPtr == null)
                throw new IllegalArgumentException(n + "is Greater than the number of nodes in the list");
            refPtr = refPtr.next;
            count++; 
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    // delete duplicates from the sorted linked List;
    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else
                current = current.next;
        }

    }

    // insert the element in the sorted linkedList condition is to maintian the
    // sorted elements order;
    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null)
            return newNode;

        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;

        return head;
    }

    // Delelte particular node
    public void deleteNode(int key) {
        ListNode current = head;
        ListNode temp = null;

        if (current != null && current.data == key) {
            head = current.next;
            return;
        }
        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        temp.next = current.next;
    }

    // Detect A Loop in a singly LinkedList in java
    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    // Create loop in singly linked list
    public void createALoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = head;

    }

    // How to find start of A Loop in a singly LinkedList in java
    public ListNode startNodeInALoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp; // starting node of the loop;
    }

    // Removig loop from linked list;
    public void removeLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    // Merging two sorted lists
    public static ListNode merge(ListNode a, ListNode b) {
        // a --> 1 --> 12 --> 23 --> 44 --> 95
        // b --> 2 --> 18 --> 27 --> 36 --> 101 --> 111 --> null
        // result --> 1 --> 2 --> 12 --> 18 --> 23 --> 27 --> 36 --> 44 --> 95 --> 101
        // --> 111 --> null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null)
            tail.next = b;
        else
            tail.next = a;

        return dummy.next;
    }

    /*
     * Add Two Lists
     * Given two non empty linked lists representing two non negative integers. The
     * digits are stored in reverse order, and each of their nodes contains a single
     * digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not containig leading any leading zero,
     * except the number 0 itself.
     */
    public static ListNode addTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;

        }
        if (carry > 0)
            tail.next = new ListNode(carry);

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        // ListNode head = new ListNode(23);
        // ListNode second = new ListNode(10);
        // ListNode third = new ListNode(1);
        // ListNode fourth = new ListNode(11);

        // head.next = second;
        // second.next = third;
        // third.next = fourth;

        // sll.insertAtFirst(12);
        // sll.insertAtFirst(14);
        // sll.insertAtFirst(14);
        // sll.insertAtFirst(15);
        // sll.insertAtFirst(15);
        // sll.insertAtFirst(19);
        // sll.insertAtFirst(19);
        
        
        // sll.insertAtLast(12);
        // sll.insertAtLast(14);
        // sll.insertAtLast(14);
        // sll.insertAtLast(16);
        // sll.insertAtLast(16);
        // sll.insertAtLast(17);
        // sll.display();

        // sll.insert(1, 29);
        // sll.insert(2, 3);
        // sll.insert(1, 70);
        // sll.insert(4, 170);
        // sll.display();
        // System.out.println("\n The length of the list is : " + sll.length());
        // System.out.println(sll.deleteAtFirst().data);
        // sll.display();

        // System.out.println(sll.deleteAtLast().data);
        // System.out.println(sll.deleteAtLast().data);
        // System.out.println(sll.deleteAtLast().data);
        // System.out.println(sll.deleteAtLast().data);
        // System.out.println(sll.deleteAtLast().data);
        // sll.display();

        // 70 --> 29 --> 3 --> 170 --> null
        // sll.delete(3);
        // sll.display(); // 70 --> 29 --> 170 --> null

        // sll.delete(1);
        // sll.display(); // 29 --> 170 --> null

        // sll.delete(2);
        // sll.display(); // 29 --> null

        // sll.delete(1);
        // sll.display(); // null
        // sll.display();

        // if(sll.find(head,12)){
        // System.out.println("search key foud");
        // } else{
        // System.out.println("Search Key Not found");
        // }
        // sll.display(head);

        // ListNode reversListNode = sll.reverse(head);
        // sll.display(reversListNode);

        // ListNode middleNode = sll.getMiddleNode();
        // System.out.println("MiddleNode is "+ middleNode.data);

        // ListNode NthNodeFromEnd = sll.getNthNodeFromEnd(3);
        // System.out.println(NthNodeFromEnd.data);

        // sll.removeDuplicates();
        // sll.display();

        // sll.insertInSortedList(15);
        // sll.insertInSortedList(13);
        // sll.display();

        // // deleting particular node
        // sll.deleteNode(13);
        // sll.display();

        // Detect Loop in List
        // sll.createALoopInLinkedList();
        // // sll.display();
        // System.out.println(sll.containsLoop());

        // Start node of the loop
        // sll.createALoopInLinkedList();
        // System.out.println(sll.containsLoop());
        // System.out.println(sll.startNodeInALoop().data);

        // Removing Loop from list;
        // sll.createALoopInLinkedList();
        // System.out.println(sll.containsLoop());
        // System.out.println(sll.startNodeInALoop().data);
        // sll.removeLoop();
        // sll.display();

        // To merge two sorted list
        // SinglyLinkedList sll1 = new SinglyLinkedList();
        // sll1.insertAtLast(12);
        // sll1.insertAtLast(14);
        // sll1.insertAtLast(16);

        // SinglyLinkedList sll2 = new SinglyLinkedList();
        // sll2.insertAtLast(13);
        // sll2.insertAtLast(15);
        // sll2.insertAtLast(17);
        // sll2.insertAtLast(19);
        // sll2.insertAtLast(117);
        // sll2.insertAtLast(119);

        // sll1.display();
        // sll2.display();

        // SinglyLinkedList resultingList = new SinglyLinkedList();
        // resultingList.head = merge(sll1.head, sll2.head);

        // resultingList.display();

        // // Adding Two Lists:

        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertAtLast(7);
        sll1.insertAtLast(4);
        sll1.insertAtLast(9);

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertAtLast(5);
        sll2.insertAtLast(6);
        sll2.insertAtLast(2);
        sll1.display();
        sll2.display();

        SinglyLinkedList resultingListOfAdd = new SinglyLinkedList();
        resultingListOfAdd.head = addTwoLists(sll1.head, sll2.head);
        resultingListOfAdd.display();
        // sll.insert(4, 10);
        // sll.display();


    }
}
