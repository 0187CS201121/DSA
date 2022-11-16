import java.util.NoSuchElementException;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

public class Circular_Singly_LinkedList {
    private ListNode last;
    private int length;
    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data=data;
        }
    }
    public Circular_Singly_LinkedList(){
        last=null;
        length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public void createCircularSinglyLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=first;

        last=sixth;
        
    }
    public void display(){
        if(last==null){
        return;
        }
        ListNode first = last.next;
        while(first!=last){
            System.out.print(first.data+ " ");
            first=first.next;
        }
        System.out.println(first.data);
    }
    public void insertAtFirst(int data){
        ListNode temp=new ListNode(data);
        if(last==null) last = temp;
        else temp.next=last.next;

        last.next=temp;
        length++;
    }
    public void insertAtLast(int data){
        ListNode temp=new ListNode(data);
        if(last==null){
            last=temp;
            last.next=last;
        }else{
            temp.next=last.next;
            last.next=temp;
            last=temp;
        }
        length++;
    }
    public ListNode removeAtFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if(last.next==last) last=null;
        else last.next=temp.next;

        temp.next=null;
        length--;

        return temp;

    }
    public static void main(String[] args) {
        Circular_Singly_LinkedList csll=new Circular_Singly_LinkedList();
        // csll.createCircularSinglyLinkedList();
        // csll.display();
        // csll.insertAtFirst(3);
        // // csll.display();
        // csll.insertAtFirst(23);
        // // csll.display();
        
        // // csll.display();
        // csll.insertAtFirst(23);
        // csll.display();
        csll.insertAtLast(4);
        csll.insertAtLast(44);
        csll.insertAtLast(14);
        csll.insertAtLast(444);
        csll.display();

        csll.removeAtFirst();
        csll.removeAtFirst();
        csll.removeAtFirst();
        // csll.removeAtFirst();
        csll.display();
    }
}
