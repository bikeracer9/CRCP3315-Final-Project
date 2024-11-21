/*
 * Prescott Lau
 * November 14th 2024
 * 
 * This class is the Node class. It has the code to create a single object (a Node) 
 * that the LinkedList class uses to create a longer list of these Nodes.
 * 
 * This class has these data objects: the count of total coins the player owns, X, & X.
 */
package com.final_project;

public class Node {

    Node nextNode;
    int coinCount;
    
    public Node(int coinCount)
    {
        this.coinCount = coinCount;
        nextNode = null;
    }


    /*
     * Getters and Setters for the next Node
     */
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node n)
    {
        this.nextNode = n;
    }


    /*
     * Getters and Setters for the coinCount
     */
    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int c)
    {
        this.coinCount = c;
    }

}
