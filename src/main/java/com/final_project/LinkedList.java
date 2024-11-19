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



}
