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
    int HeartCoinCost = 1; //10
    int SubCoinCost = 1; //25
    int SubGoldCoinCost = 1; //50

    LinkedList list = new LinkedList(); 
    Battleship ship;

    boolean errorInput = false;
    int errorCode = -1; 
    /* List of error codes: 
    *              0 = "Not enough coins" to make a purchase
    *              1 = "Haven't bought sprite" - cannot switch avatar bc havent bought yet
    *              2 = "Max # of Extra Hearts" - Maximum # of Extra Hearts already bought
    *              3 = "Default Skin Already Equipped" - ditto 
    */


    ShopController(PApplet main_, LinkedList list_, Battleship ship_)
    {
        super(main_);
        this.list = list_;
        this.ship = ship_;
        
        battleshipSprite[0] = main.loadImage("./images/battleship_2.png"); //default
        battleshipSprite[1] = main.loadImage("./images/sub.png"); //sub
        battleshipSprite[2] = main.loadImage("./images/sub_gold.png"); //gold sub

        unlockedSpriteSub = false;
        unlockedSpriteSubG = false;
    }

    public void draw()
    {
        //background:
        main.rectMode(3);
        main.background(0,128,255);
        main.fill(0);

        drawExtraHearts(); //   <-- draws the extra hearts bought next to the button

        //add the buttons (draws them over the other images to reveal them upon purchase)
        addButtons();
        drawText(); //   <-- checks draws the text

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
        
        checkErrors(errorInput); //   <-- checks 4 errors with extra Lives and draws error button across screen
    }
    

    void drawText()
    {
        //---- text at the top:
        main.fill(0);
        main.textSize(45);
        main.text("Shop:", main.width/2 - 100, 85);
        // ---------

        //Buy Extra Lives text:
        main.fill(0);
        main.textSize(30);
        main.text("10 coins - Buy Extra Lives:", 40, 200 ); 
        main.textSize(18);
        main.text("(MAX OF 3)", 170, 225 );
        // ---------

        //Appearance text:
        //Buy Extra Lives text:
        main.fill(0);
        main.textSize(30);
        main.text("Change Appearance:", 40, 325 ); 
        main.textSize(16);
        main.text("(Click Equip Button to Change)", 69, 355 );
        // ---------

        //Buy & Equip Submarine Text:
        main.fill(0);
        if(!unlockedSpriteSub)
        {
            main.textSize(30);
            main.text("Buy:", 335, 658 ); 
        }
       
        main.textSize(29);
        main.text("Equip:", 309, 722 ); 
        // ---------

        //Buy & Equip GOLD Submarine Text:
        main.fill(0);
        if(!unlockedSpriteSubG)
        {
            main.textSize(30);
            main.text("Buy:", 970, 658 ); 
        }
       
        main.textSize(29);
        main.text("Equip:", 944, 722 );  
        // ---------

        //Reset to Default skin Button's text
        main.textSize(17);
        main.text(" Default Skin:", 38, main.height - 30 ); 
        // ---------
    }//end of drawText()

/*
 * THIS CONTROLS ALL OF THE MOUSE PRESSED FUNCTIONS FOR THE BUTTONS.
 */
    public void mousePressed()
    {   
        if (errorInput) 
        {
            errorInput = false;
            return; 
        }

        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
        
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
            else if( ( totalCoins >= HeartCoinCost ) && ( ship.getExtraLivesCount() == 3 ) )
            {
                errorInput = true; 
                errorCode = 2; //not enough coins
            }
            else
            {
                errorInput = true; 
                errorCode = 0; //not enough coins
            }
        }

        //BUY SUBMARINE BUTTON:
        if( (main.mouseX >= 402) && (main.mouseX <= 448) && (main.mouseY >= 627) && (main.mouseY <= 673) && !unlockedSpriteSub )
        {
            if( totalCoins >= SubCoinCost  )
            {
                removeCoins(SubCoinCost);
                unlockedSpriteSub = true;
            }
            else{
                errorInput = true; 
                errorCode = 0; //not enough coins
            }
        }

        //EQUIP SUBMARINE BUTTON:
        if( (main.mouseX >= 402) && (main.mouseX <= 448) && (main.mouseY >= 692) && (main.mouseY <= 738) )
        {
            if( unlockedSpriteSub )
            {
                equippedSprite = 1;
                ship.setImage(battleshipSprite[1]); 
            }
            else
            {
                errorInput = true;
                errorCode = 1; //haven't bought sprite yet, cannot equip
            }
        }

        //BUY GOLD SUBMARINE BUTTON:
        if( (main.mouseX >= 1037) && (main.mouseX <= 1083) && (main.mouseY >= 627) && (main.mouseY <= 673)  && !unlockedSpriteSubG )
        {
            if( totalCoins >= SubGoldCoinCost  )
            {
                removeCoins(SubGoldCoinCost);
                unlockedSpriteSubG = true;
            }
            else{
                errorInput = true; 
                errorCode = 0; //not enough coins
            }
        }

        //EQUIP GOLD SUBMARINE BUTTON:
        if( (main.mouseX >= 1037) && (main.mouseX <= 1083) && (main.mouseY >= 692) && (main.mouseY <= 738) )
        {
            if( unlockedSpriteSubG )
            {
                equippedSprite = 2;
                ship.setImage(battleshipSprite[2]); 
            }
            else
            {
                errorInput = true;
                errorCode = 1; //haven't bought sprite yet, cannot equip
            }
        }

        //RESET TO DEFAULT (BATTLESHIP) SKIN 
        if( (main.mouseX >= 33) && (main.mouseX <= 157) && (main.mouseY >= 747) && (main.mouseY <= 783))
        {
            if(equippedSprite != 0)
            {
                equippedSprite = 0;
                ship.setImage(battleshipSprite[0]); 
            }
            else
            {
                errorInput = true;
                errorCode = 3;
            }
            
        }

    }//end of mousePressed()

    /*
     * This function draws all the buttons on the Attempt page. 
     * A BUTTON CONSISTS OF ALL OF THE WHITE (& GREEN & PURPLE ) SQUARES.
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

        //Reset to Default skin button (Battleship image)

            if( (main.mouseX >= 33) && (main.mouseX <= 157) && (main.mouseY >= 747) && (main.mouseY <= 783) )
            { //green (if user is hovering over)
                main.fill(23, 227, 33);
                main.rectMode(3);
                main.rect(95, main.height - 35, 125,36 );
            }
            else if( equippedSprite == 0 ) 
            {
                main.fill(160, 22, 201); //if its equipped, make it purple!
                main.rectMode(3);
                main.rect(95, main.height - 35, 125,36 );
            }
            else
            { // //white (if user is NOT hovering over)
                main.fill(255);
                main.rectMode(3);
                main.rect(95, main.height - 35, 125,36 ); 
            }
        //------
        
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
        
        main.image(battleshipSprite[1], 245, 425, 320 - 35, 175 - 10); //draws the picture of the submarine
        main.fill(0);
        main.text("SUBMARINE", 565, 545);
        main.text("25 coins", 585, 585);
            //Buy Button:
                if( (main.mouseX >= 402) && (main.mouseX <= 448) && (main.mouseY >= 627) && (main.mouseY <= 673) && !unlockedSpriteSub )
                { //green (if user is hovering over)
                    main.fill(23, 227, 33);
                    main.rectMode(3);
                    main.rect(425, 650, 46,46 );
                }
                else if( unlockedSpriteSub )
                {
                    //do nothing (dont draw itself)
                }
                else
                { // //white (if user is NOT hovering over)
                    main.fill(255);
                    main.rectMode(3);
                    main.rect(425, 650, 46,46 );
                }
            //-----

            //Equip Button
                if( (main.mouseX >= 402) && (main.mouseX <= 448) && (main.mouseY >= 692) && (main.mouseY <= 738) )
                { //green (if user is hovering over)
                    main.fill(23, 227, 33);
                    main.rectMode(3);
                    main.rect(425, 715, 46,46 );
                }
                else if( equippedSprite == 1 )
                {
                    main.fill(160, 22, 201); //if its equipped, make it purple!
                    main.rectMode(3);
                    main.rect(425, 715, 46,46 );
                }
                else
                { // //white (if user is NOT hovering over)
                    main.fill(255);
                    main.rectMode(3);
                    main.rect(425, 715, 46,46 );
                }
            //------

        //------------


       //Buy & Equip GOLD Submarine Buttons:
    
       main.image(battleshipSprite[2], 855, 425, 320 - 25, 175 ); //draws the picture of the GOLD submarine
       main.fill(245, 216, 0);
       main.text("GOLDEN \n    SUB", 1185, 520);
       main.text("50 coins", 1185, 600);
       //Buy Button:
           if( (main.mouseX >= 1037) && (main.mouseX <= 1083) && (main.mouseY >= 627) && (main.mouseY <= 673) && !unlockedSpriteSubG )
           { //green (if user is hovering over)
               main.fill(23, 227, 33);
               main.rectMode(3);
               main.rect(1060, 650, 46,46 );
           }
           else if( unlockedSpriteSubG )
           {
               //do nothing (dont draw itself)
           }
           else
           { // //white (if user is NOT hovering over)
               main.fill(255);
               main.rectMode(3);
               main.rect(1060, 650, 46,46 );
           }
       //-----

       //Equip Button
           if( (main.mouseX >= 1037) && (main.mouseX <= 1083) && (main.mouseY >= 692) && (main.mouseY <= 738) )
           { //green (if user is hovering over)
               main.fill(23, 227, 33);
               main.rectMode(3);
               main.rect(1060, 715, 46,46 );
           }
           else if( equippedSprite == 2 )
           {
               main.fill(160, 22, 201); //if its equipped, make it purple!
               main.rectMode(3);
               main.rect(1060, 715, 46,46 );
           }
           else
           { // //white (if user is NOT hovering over)
               main.fill(255);
               main.rectMode(3);
               main.rect(1060, 715, 46,46 );
           }
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
    }// end of removeCoins()

    void checkErrors(boolean i)
    {
        if(i == true)
        {
            main.fill(255,15,5, 245);
            main.rectMode(3);
            main.rect(main.width/2, main.height/2, main.width, 125); 
            main.fill(0);
            main.textSize(45);
            
            if ( (errorCode == 0) )
            {
                main.text("Not enough Coins!", main.width/2 - 170, main.height/2 + 15);
            }
            else if( (errorCode == 1) ) 
            {
                main.text("Haven't Bought this Sprite, Cannot Equip!", 245, main.height/2 + 15);
            }
            else if( (totalCoins >= HeartCoinCost ) && (ship.getExtraLivesCount()  == 3) && (errorCode == 2) )
            {
                main.text("Maximum Amount of Extra Hearts Bought!", 245, main.height/2 + 15);
            }
            else if( errorCode == 3)
            {
                main.text("Default Skin Already Equipped!", 390, main.height/2 + 15);
            }
                
        }
        else
        {

        }
    }//end of checkErrors()

    void drawExtraHearts()
    {
        int extraHearts = ship.getExtraLivesCount();
        int x = 35;
        for(int i = 0; i < extraHearts; i++)
        {
            main.image(extraHealthImage, 490 + x, 175, 46, 46);
            x += 55;
        }
    }// end of drawExtraHearts()

}//end of ShopController class
