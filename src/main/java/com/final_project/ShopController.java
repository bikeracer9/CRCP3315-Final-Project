/*
 * Prescott Lau
 * November 19th 2024
 * 
 * This class is the Shop class. 
 * 
 * It allows the user to customize the gameplay: buy more lives, change their appearance.
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class ShopController extends GameController{
    PImage battleshipImg = main.loadImage("./images/battleship.png");

    int totalCoins;

    LinkedList list = new LinkedList(); 
    
    int coins;

    ShopController(PApplet main_, LinkedList list_)
    {
        super(main_);
        this.list = list_;
    }

    public void draw()
    {
        //background:
        main.rectMode(3);
        main.background(0,128,255);
        main.fill(0);

        //---- text at the top:
        main.textSize(45);
        main.text("Shop:", main.width/2 - 100, 85);

        //this part of code goes through the LinkedList to see how many runs have happened
        // and shows them on the screen. 
        main.fill(0);
        main.textSize(35);

        int cC = 0;

        if (!list.isEmpty()) 
        {

            Node current = list.head;
            while (current != null) 
            {
                cC = cC + current.getCoinCount();
                current = current.getNextNode();
            }
        }

        main.text("Coins: " + cC, 30, 65);

        // getTotalCoinCount();
        
        // if (!list.isEmpty()) {
        //     int attemptC = 1;
        //     Node current = list.head;
        //     int yPosition = 65;

        //     while (current != null) {
        //         main.text("Attempt: " + attemptC + " Coins: " + current.getCoinCount(), 35, yPosition);
        //         yPosition += 35; 
        //         current = current.getNextNode();
        //         attemptC++;
        //     }
        // } else {
        //     main.text("No attempts made yet.", 35, 65);
        // }
    }
    
    public void mousePressed()
    {   

    }

    public void getTotalCoinCount()
    {
        totalCoins = 0;
        Node current = list.head;
        while(current != null)
        {
            totalCoins += current.getCoinCount();
        }
    }
}
