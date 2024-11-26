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
    //PImage battleshipImg = main.loadImage("./images/battleship.png");


    PImage[] battleshipSprite = new PImage[3];
    int equippedSprite = 0;

    boolean unlockedSpriteSub;
    boolean unlockedSpriteSubG;

    PImage extraHealthImage = main.loadImage("./images/extraHealth.png");

    int totalCoins;
    int HeartCoinCost = 1;
    int SubCoinCost = 1;
    int SubGoldCoinCost = 1;

    LinkedList list = new LinkedList(); 
    Battleship ship;

    boolean errorInput = false;

    ShopController(PApplet main_, LinkedList list_, Battleship ship_)
    {
        super(main_);
        this.list = list_;
        this.ship = ship_;
        
        battleshipSprite[0] = main.loadImage("./images/battleship.png"); //default
        // battleshipSprite[1] = main.loadImage("./images/sub.png"); //sub
        // battleshipSprite[2] = main.loadImage("./images/sub_gold.png"); //gold sub

        unlockedSpriteSub = false;
        unlockedSpriteSubG = false;
    }

    public void draw()
    {
        //background:
        main.rectMode(3);
        main.background(0,128,255);
        main.fill(0);

        drawText(); //   <-- checks draws the text

        checkHeartErrors(errorInput); //   <-- checks 4 errors with extra Lives and draws error button across screen
        drawExtraHearts(); //   <-- draws the extra hearts bought next to the button

        //add the buttons (draws them over the other images to reveal them upon purchase)
        addButtons();

        //this part of code below goes through the LinkedList to see how many runs have happened
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

        //PRINTS THE COINS AT TOP LEFT:
        main.text("Coins: " + cC, 30, 65);
        totalCoins = cC;
        
    }
    

    void drawText()
    {
        //---- text at the top:
        main.textSize(45);
        main.text("Shop:", main.width/2 - 100, 85);


        //Buy Extra Lives text:
        main.fill(0);
        main.textSize(30);
        main.text("25 coins - Buy Extra Lives:", 40, 200 ); 
        main.textSize(18);
        main.text("(MAX OF 3)", 170, 225 );

        //Appearance text:
        //Buy Extra Lives text:
        main.fill(0);
        main.textSize(30);
        main.text("50 coins - Change Appearance:", 40, 325 ); 
        main.textSize(16);
        main.text("(Click Equip Button to Change)", 140, 355 );
    }


    public void mousePressed()
    {   
        if (errorInput) 
        {
            errorInput = false;
            return; 
        }

        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!

        //PLAY AGAIN BUTTON
        if( (main.mouseX >= 938) && (main.mouseX <= 1132) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            nextController = GameController.GAME_PLAY; //go to gameplay!
        }
        
        //ATTEMPTS BUTTON
        if( (main.mouseX >= 1168) && (main.mouseX <= 1362) && (main.mouseY >= 48) && (main.mouseY <= 102) )
        {
            nextController = GameController.ATTEMPTS; //go to the shop!
        }

        //BUY EXTRA (MAX of 3) LIVES BUTTON
        if( (main.mouseX >= 457) && (main.mouseX <= 503) && (main.mouseY >= 172) && (main.mouseY <= 218) )
        {
            if( ( totalCoins >= HeartCoinCost ) && ( ship.getExtraLivesCount() < 3 )  ) // !!!
            {
                removeCoins(HeartCoinCost);
                ship.addExtraLives(1);
                System.out.println("Ship extra Lives: " + ship.getExtraLivesCount() );
            }
            else
            {
                errorInput = true; 
            }
        }

    }

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

        
        //Buy more Lives buttons: ///----------
        if( (main.mouseX >= 457) && (main.mouseX <= 503) && (main.mouseY >= 172) && (main.mouseY <= 218) )
        {
            //Green Buy 3 more Lives button: (if user IS hovering over)
            main.fill(23, 227, 33);
            main.rectMode(3);
            main.rect(480, 195, 46,46 );
        }
        else
        {
            //White Buy 3 more Lives button: (if user is NOT hovering over)
            main.fill(255);
            main.rectMode(3);
            main.rect(480, 195, 46,46 );
        }
        ///----------------------------------------------
        
        //Buy & Equip Submarine Buttons:
            //Buy:
        

            //-----


            //Equip

            //------

        //------------


        //Buy & Equip GOLD Submarine Buttons:
            //Buy:


            //-----


            //Equip

            //------

        //------------


        

//----------------


    }//end of addButtons()

    public void removeCoins(int amount) 
    {
        int remaining = amount;
        Node current = list.head;
        while ( (current != null) && ( remaining > 0 ) ) {
            int coins = current.getCoinCount();
            if ( coins >= remaining ) 
            {
                current.setCoinCount(coins - remaining);
                remaining = 0;
            } 
            else 
            {
                current.setCoinCount(0);
                remaining -= coins;
            }
            current = current.getNextNode();
        }
    }

    void checkHeartErrors(boolean i)
    {
        if(i == true)
        {
            if( (totalCoins >= HeartCoinCost ) && (ship.getExtraLivesCount()  == 3) )
            {
                main.fill(255,15,5, 245);
                main.rectMode(3);
                main.rect(main.width/2, main.height/2, main.width, 125); 
                main.fill(0);
                main.textSize(45);
                main.text("Maximum Amount of Extra Hearts Bought!", 245, main.height/2 + 15);
            }
            else
            {
                main.fill(255,15,5, 245);
                main.rectMode(3);
                main.rect(main.width/2, main.height/2, main.width, 125); 
                main.fill(0);
                main.textSize(45);
                main.text("Not enough Coins!", main.width/2 - 170, main.height/2 + 15);
            }
                
        }
        else
        {

        }
    }

    void drawExtraHearts()
    {
        int extraHearts = ship.getExtraLivesCount();
        int x = 35;
        for(int i = 0; i < extraHearts; i++)
        {
            main.image(extraHealthImage, 490 + x, 175, 46, 46);
            x += 55;
        }
    }
}
