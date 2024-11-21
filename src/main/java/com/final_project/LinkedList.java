/*
 * Prescott Lau
 * Novemeber 14th 2024
 * 
 * This class is the LinkedList class. It has all the code to add and maintain a list of
 * the Node objects.
 * 
 */

package com.final_project;

public class LinkedList {

    Node head; //head of the LinkedList

    public LinkedList()
    {
        head = null;
    }//end of constructor

    /*
     * Boolean to return "true" if the list is empty.
     */
    boolean isEmpty()
    {
        return head == null;
    }//end of isEmpty()

    void print()
    {
        if(isEmpty())
        {
            System.out.println( " ");
        }

        Node current = head;

        while(current != null)
        {
            System.out.println(current.toString());

            current = current.getNextNode();
        }

        System.out.println("");
    }//end of print()

    void insertAtEnd(Node n)
    {
        if(head == null)
        {
            head = n;
        }

        else{
            Node current = head;
            while(current.getNextNode() != null) 
            {
                current = current.getNextNode();
            }
            current.setNextNode(n);
        }
    }//end of insertAtEnd()

    void clear()  // ?
    {
        head = null;
    }//end of clear()

       
    /*
    * Reverse method: Reverses the List!
    */
    public void reverse()
    {
        System.out.println("Reversing the Melody: ");
        Node previous = null;//set the previous node to be null.
        Node current = head; //set the current node to be the head node.
        Node next = null;    //set the next node to be null.

        while(current != null) //while loop to go through the list.
        {
            next = current.getNextNode(); //store the next node
            current.setNextNode(previous); //set current node to previous node (reverse)
            previous = current; //previous node moves forwards to next one
            current = next; //move to the next node
        }
        head = previous; //head node changes to previous node
    }
    
    public int getSize()
    {
        Node current = head;
        int c = 0;
        while(current != null)
        {
            current = current.getNextNode();
            c++;
        }
        return c;
    }


}
