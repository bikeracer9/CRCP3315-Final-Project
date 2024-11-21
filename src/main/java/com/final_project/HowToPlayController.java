/*
 * Prescott Lau
 * November 20th 2024
 * 
 * This class is the HowToPlay class. It provides information about... how to play this game!
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class HowToPlayController extends GameController{

    PImage bombImg = main.loadImage("./images/bomb_3.png"); 
    PImage battleshipImg = main.loadImage("./images/battleship.png");
    PImage coinImg = main.loadImage("./images/coin.png");
    PImage powerUpImage = main.loadImage("./images/powerUp_1.png");

    HowToPlayController(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        //background:
        main.rectMode(3);
        // main.noStroke();
        main.background(0,128,255);
        main.fill(0);

        //---- text (with images) about how to play:
        main.textSize(45);
        main.text("How to Play:", main.width/2 - 125, 85);

        main.rectMode(0);

        //battleship
        main.image(battleshipImg, main.width/2 - 450, 135, 160, 160);
        main.textSize(28);
        main.text("Move your Battleship with the 'WASD' keys", main.width/2 - 265, 236);
        // main.text("Stay alive for as long as you can!", main.width/2 - 265, 285);

        //bomb
        main.image(bombImg, main.width/2 - 425, 295, 100, 100);
        main.text("Avoid touching the mines, they hurt!", main.width/2 - 265, 357);

        //coins
        main.image(coinImg, main.width/2 - 425, 425, 100, 100);
        main.text("Collect coins to redeem rewards in the shop!", main.width/2 - 265, 483);

        //powerup
        main.image(powerUpImage, main.width/2 - 420, 560, 100, 100);
        main.text("Collect power ups to test your luck!", main.width/2 - 265, 618);        


        //---- button back to intro!
        main.rectMode(3);
        main.fill(255);
        main.rect(105, 55, 165,65 );
        main.fill(0);
        main.textSize(40);
        main.text("Back",60, 70 );
    }

    public void mousePressed() ///MAKE SURE WORKS FOR FINAL VERSION!
    {
        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!
        if( (main.mouseX >= 23) && (main.mouseX <= 187) && (main.mouseY >= 22 ) && (main.mouseY <= 88) )
        {
            nextController = GameController.INTRO; //go back to the intro screen after reading abt how to play.
        }


    }

    public void mouseDragged()
    {

    }

    public void keyPressed()
    {
    }


}
