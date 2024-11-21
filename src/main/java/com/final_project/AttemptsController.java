/*
 * Prescott Lau
 * November 21st 2024
 * 
 * This class shows previous attempts made by the player using a LinkedList and their Nodes.
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class AttemptsController extends GameController{
    PImage battleshipImg = main.loadImage("./images/battleship.png");

    LinkedList list = new LinkedList(); 
    
    int coins;

    AttemptsController(PApplet main_, LinkedList list_)
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
        main.text("Attempts:", main.width/2 - 95, 85);
        main.textSize(35);

        //text for attempts:
        if (!list.isEmpty()) {
            int attemptC = 1;
            Node current = list.head;
            int yPosition = 145;
            
            while (current != null) {
                main.text("Attempt: " + attemptC + "  Coins: " + current.getCoinCount(), 25, yPosition);
                yPosition += 40; 
                current = current.getNextNode();
                attemptC++;
            }
        } else {
            main.text("No attempts made yet.", 35, 65);
        }

        addButtons();
        
    }

    /*
     * This function draws all the buttons on the Attempt page.
     */
    public void addButtons()
    {
        //Play Again Button below:
        main.fill(255);
        main.rectMode(3);
        main.rect(main.width - 365, 75, 195,55 );
        main.fill(0);
        main.textSize(30);
        main.text("Play Again", main.width - 440, 85 );


        //Shop Button below:
        main.fill(255);
        main.rectMode(3);
        main.rect(main.width - 135, 75, 195,55 );
        main.fill(0);
        main.textSize(30);
        main.text("Shop", main.width - 175, 85 );
    }//end of addButtons()

    public void mousePressed()
    {
        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!

        //PLAY AGAIN
        if( (main.mouseX >= 938) && (main.mouseX <= 1132) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            nextController = GameController.GAME_PLAY; //go to gameplay!
            // System.out.println("PLAY");
        }

        if( (main.mouseX >= 1168) && (main.mouseX <= 1362) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            nextController = GameController.SHOP; //go to the shop!
            // System.out.println("SHOP");
        }
    }
}