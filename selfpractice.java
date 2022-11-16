package LinkedList;

public class selfpractice {

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
            System.out.print("null");

        ListNode current = head;

        while (null != current) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null" + "\n");
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
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    public void insert(int possition, int value) {
        ListNode node = new ListNode(value);
        if (possition == 1) {
            node.next = head;
            head = node;
        }
        int count = 1;
        ListNode previous = head;
        while (count < possition - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = node;
        node.next = current;
    }

    public ListNode deleteAtFirst() {
        ListNode temp = head;
        head = head.next;
        temp.next = null;

        return temp;
    }

    public ListNode deleteAtLast() {
        ListNode current = head;
        ListNode previous = null;
        if (head == null || head.next == null)
            return head;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public ListNode delete(int possition) {
        if (possition == 1) {
            head = head.next;
        }
        ListNode previous = head;
        int count = 1;
        while (count < possition - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = current.next;

        return current;
    }

    public void deleteByKey(int key) {
        ListNode current = head;
        ListNode previous = null;
        if (key == head.data)
            head = head.next;
        while (current.next != null) {
            previous = current;
            current = current.next;
            if (key == current.data) {
                previous.next = current.next;
            }

        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null)
            return head;

        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        return previous;
    }

    public ListNode getMiddleListNode() {
        if (head == null)
            return head;

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromLast(int n) {
        if (head == null)
            return null;
        if (n <= 0)
            throw new IllegalArgumentException("invalid value n = " + n);

        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n) {
            if (refPtr == null)
                throw new IllegalArgumentException(n + " is greater than the number of nodes in the list");
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    // Remove duplicates from list
    public void removeDuplicates() {
        if (head == null)
            return;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else
                current = current.next;
        }
    }

    // insert the newnode in sorted list
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

    // delete node 
    public void deleteByGivenKey(int key){
        ListNode current = head;
        ListNode temp = null;
         
        if(current != null && current.data == key) head = current.next;

        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null) return;

        temp.next = current.next;
    }

    public boolean containsLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) return true;
        }
        return false;
    }

    public void createLoop(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = fourth;
    }

    // geting start node of a loop;

    public ListNode startNodeInALoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) return getStartNodeInALoop(slowPtr);
        }
        return null;
    }

    public ListNode getStartNodeInALoop(ListNode slowPtr){
        ListNode temp = head;
        while(temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }
//remove loop
    public ListNode removeALoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) return removeLoop(slowPtr);
        }
        return null;
    }

    public ListNode removeLoop(ListNode slowPtr){
        ListNode temp = head;

        while(temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;

        return head;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(a != null && b != null){

            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }
            else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;

        }
        if(a == null) tail.next = b;
        if(b == null) tail.next = a;

        return dummy.next;
    }

    // adding two lists
    public static ListNode addTwoLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(a != null || b != null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if(a != null) a = a.next;
            if(b != null) b = b.next;

        }
        if(carry > 0) tail.next = new ListNode(carry);

        return dummy.next;
    }
    public static void main(String[] args) {
        selfpractice sp = new selfpractice();

        // sp.head = new ListNode(23);
        // ListNode second = new ListNode(5);
        // ListNode third = new ListNode(12);
        // ListNode fourth = new ListNode(5);
        // ListNode fifth = new ListNode(12);

        // sp.head.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        // sp.display(sp.head);

        // sp.insertAtFirst(4);
        // sp.display();

        // sp.insertAtLast(5);
        // sp.insertAtLast(5);
        // sp.insertAtLast(5);
        // sp.insertAtLast(6);
        // sp.insertAtLast(7);
        // sp.insertAtLast(8);
        // sp.insertAtLast(8);
        // sp.insertAtLast(10);

        // sp.display();

        // sp.insert(5,14);
        // sp.display();

        // System.out.println(sp.deleteAtFirst().data);
        // System.out.println(sp.deleteAtFirst().data);
        // System.out.println(sp.deleteAtFirst().data);
        // System.out.println(sp.deleteAtFirst().data);
        // System.out.println(sp.deleteAtFirst().data);
        // System.out.println(sp.deleteAtFirst().data);
        // sp.display();

        // System.out.println(sp.deleteAtLast().data);
        // sp.display();

        // System.out.println(sp.delete(5).data);
        // sp.display();

        // sp.deleteByKey(61);
        // sp.deleteByKey(45);
        // sp.display();

        // ListNode reverseListnode = sp.reverse(sp.head);
        // sp.display(reverseListnode);

        // ListNode middleNode = sp.getMiddleListNode();
        // System.out.println(middleNode.data);

        // ListNode nthNode = sp.getNthNodeFromLast(7);
        // System.out.println(nthNode.data);

        // sp.removeDuplicates();
        // sp.display();

        // sp.insertInSortedList(10);
        // sp.display();

        // // sp.deleteByGivenKey(10);
        // sp.deleteByGivenKey(5);
        // sp.display();

        // sp.createLoop();
        // boolean check = sp.containsLoop(sp.head);
        // System.out.println(check);
        // ListNode checkStartNode = sp.startNodeInALoop();
        // System.out.println(checkStartNode.data);
        // sp.removeALoop();
        // sp.display();

        // merging two lists
        
        // selfpractice L1 = new selfpractice();
        // L1.insertAtLast(1);
        // L1.insertAtLast(3);
        // L1.insertAtLast(5);
        // L1.insertAtLast(7);
        // L1.insertAtLast(9);
        // L1.insertAtLast(11);

        // selfpractice L2 = new selfpractice();
        // L2.insertAtLast(2);
        // L2.insertAtLast(4);
        // L2.insertAtLast(6);
        // L2.insertAtLast(10);
        // L2.insertAtLast(12);
        // L2.insertAtLast(13);
        // L2.insertAtLast(14);

        // L1.display();
        // L2.display();
        // selfpractice resultList = new selfpractice();
        // resultList.head = mergeTwoLists(L1.head, L2.head);
        // resultList.display();

        selfpractice l1 = new selfpractice();
        l1.insertAtLast(7);
        l1.insertAtLast(4);
        l1.insertAtLast(12);

        selfpractice l2 = new selfpractice();
        l2.insertAtLast(17);
        l2.insertAtLast(14);
        l2.insertAtLast(12);

        l1.display();
        l2.display();

        selfpractice resultingAdditionList = new selfpractice();
        resultingAdditionList.head = addTwoLists(l1.head,l2.head);
        resultingAdditionList.display();
    }
}