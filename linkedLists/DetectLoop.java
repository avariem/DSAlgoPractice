/**
 Given a linked list of N nodes such that it may contain a loop.
 A loop here means that the last node of the link list is connected to the node at position X.
 If the link list does not have any loop, X=0.
 Remove the loop from the linked list, if it is present.

 Example 1:
 Input:
 N = 3
 value[] = {1,3,4}
 X = 2
 Output: 1
 Explanation: The link list looks like
 1 -> 3 -> 4
 ^    |
 |____|
 A loop is present. If you remove it
 successfully, the answer will be 1.

 */
package com.practice.linkedLists;

public class DetectLoop {

    public void detectLoop(Node head){
        if(head == null)
            return;
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                break;
            }
        }
        if(slow == fast){
            slow = head;
            if(slow!=fast){
                while(slow.next!=fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
        }else{
            while(fast.next!=slow){
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static class Node{
        int data;
        Node next;
    }
}
