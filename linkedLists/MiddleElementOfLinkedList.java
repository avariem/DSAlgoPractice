/**
 Finding middle element in a linked list
 Easy Accuracy: 47.37% Submissions: 100k+ Points: 2
 Given a singly linked list of N nodes.
 The task is to find the middle of the linked list. For example, if the linked list is
 1-> 2->3->4->5, then the middle node of the list is 3.
 If there are two middle nodes(in case, when N is even), print the second middle element.
 For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.

 Example 1:

 Input:
 LinkedList: 1->2->3->4->5
 Output: 3
 Explanation:
 Middle of linked list is 3.
 */
package com.practice.linkedLists;

public class MiddleElementOfLinkedList {
	
	public static int getMiddle(Node head)
    {
         Node slow = head;
         Node fast = head;
         while(fast.next!=null && fast.next.next!=null){
             slow = slow.next;
             fast = fast.next.next;
         }
         if(null == fast.next){
             return slow.data;
         }else{
             return slow.next.data;
         }
    }

    static class Node{
        int data;
        Node next;
    }
}
