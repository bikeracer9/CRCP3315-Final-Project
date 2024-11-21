/*
 * Prescott Lau 
 * Final Project
 * November 11th 2024
 * This is the introduction Game State.
 */
package com.final_project;

import processing.core.PApplet;

public class GameIntro extends GameController {

    // PImage photo = main.loadImage("./images///bomb_2_w.jpg"); //declaring the image

    GameIntro(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.rectMode(3);
        main.background(0,128,255);
        main.fill(0);
        main.textSize(45);
        // main.image(photo, 50,50, 64,64); ////TEST IMAGE! (img, x,y, width, height)
        main.text("Welcome to Battleship!", (main.width/2) - 100, 250);
        
        addButtons();
        
    }
    public void mousePressed() ///MAKE SURE WORKS FOR FINAL VERSION!
    {
        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!
        if( (main.mouseX >= 588) && (main.mouseX <= 812) && (main.mouseY >= 363) && (main.mouseY <= 437) )
        {
            nextController = GameController.GAME_PLAY; //go to gameplay!
        }

        if( (main.mouseX >= 588) && (main.mouseX <= 812) && (main.mouseY >= 483) && (main.mouseY <= 557) )
        {
            nextController = GameController.INFORMATION; //go to information about the game!
        }

    }

    public void mouseDragged()
    {

    }

    public void keyPressed()
    {
        if (main.keyPressed)
        {
            if( main.key == ' ') //if spacebar is pressed, then do below...
            {
                nextController = GameController.GAME_PLAY; //go back to gameplay!
            }
        }  
    } 

    /*
     * This function is called in draw(), and cleans up the code.
     * It creates and draws both of the buttons on the screen. (the play & information buttons)
     */
    public void addButtons()
    {
        //Play Button below:
        main.fill(255);
        main.rectMode(3);
        main.rect(main.width/2, main.height/2, 225,75 );
        main.fill(0);
        main.textSize(40);
        main.text("Play", main.width/2 - 40, main.height/2 + 15 );

        //Information button below:
        main.fill(255);
        main.rect(main.width/2, main.height/2 + 120, 225,75 );
        main.fill(0);
        main.textSize(40);
        main.text("Info", main.width/2 - 40, main.height/2 + 135 );
    }

}
