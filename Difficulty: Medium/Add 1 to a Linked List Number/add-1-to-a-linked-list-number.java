//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        int finalcarry=func(head);
        if(finalcarry==1){
            Node newhead=new Node(1);
            newhead.next=head;
            return newhead;
        }
        return head;
    }
    
    public static int func(Node temp){
        //Node temp=head;
        if(temp==null){
            return 1;
        }
        int carry =func(temp.next);
        temp.data=carry+temp.data;
        if(temp.data<10){
            return 0;
        }
        temp.data=0;
        return 1;
    }
}

// head=reverse(head);
//         Node temp=head;
//         int carry=1;
//         while(temp!=null){
//             temp.data=temp.data+carry;
//             if(temp.data<10){
//                 carry=0;
//                 break;
//             }
//             else{
//                 carry=1;
//                 temp.data=0;
//             }
//             temp=temp.next;
//         }
//         if(carry!=0){
//             Node add=new Node(1);
//             head=reverse(head);
//             add.next=head;
//             return add;
//         }
//         head=reverse(head);
//         return head;
//     }
//     public static Node reverse(Node head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         Node newHead=reverse(head.next);
//         Node front=head.next;
//         front.next=head;
//         head.next=null;
//         return newHead;
