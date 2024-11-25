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

        addButtons();

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

        //Box next to add Lives button:
        //main.fill(255);
        //main.rectMode(3);
        //main.rect(100, 350, 195,55 );
        main.fill(0);
        main.textSize(30);
        main.text("25 coins - Buy Extra Lives:",55, 200 ); 
        main.textSize(18);
        main.text("(MAX OF 3)",185, 225 );

        
    }
    
    public void mousePressed()
    {   
        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!

        //PLAY AGAIN BUTTON
        if( (main.mouseX >= 938) && (main.mouseX <= 1132) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            nextController = GameController.GAME_PLAY; //go to gameplay!
            // System.out.println("PLAY");
        }
        
        //ATTEMPTS BUTTON
        if( (main.mouseX >= 1168) && (main.mouseX <= 1362) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            nextController = GameController.ATTEMPTS; //go to the shop!
            // System.out.println("SHOP");
        }

        //ADD (MAX of 3) LIVES BUTTON
        if( (main.mouseX >= 1168) && (main.mouseX <= 1362) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            // nextController = GameController.ATTEMPTS; //go to the shop!
            System.out.println("LIVES!");
        }

    }

    public void getTotalCoinCount()
    {
        totalCoins = 0;
        Node current = list.head;
        while(current != null)
        {
            totalCoins += current.getCoinCount();
        }
    }//end of getTotalCoinCount()


    /*
     * This function draws all the buttons on the Attempt page.
     */
    public void addButtons()
    {
        //---------------- Buttons on the top right:
        //Play Again Button below:
        main.fill(255);
        main.rectMode(3);
        main.rect(main.width - 365, 75, 195,55 );
        main.fill(0);
        main.textSize(30);
        main.text("Play Again", main.width - 440, 85 );


        //Statistics (Attempts) Button below:
        main.fill(255);
        main.rectMode(3);
        main.rect(main.width - 135, 75, 195,55 );
        main.fill(0);
        main.textSize(30);
        main.text("Attempts", main.width - 200, 85 );
        //----------------

        //---------------- Buttons for more items (coins & visual changes below:)


    }//end of addButtons()
}
