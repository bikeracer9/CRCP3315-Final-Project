/*
 * Prescott Lau 
 * Final Project
 * November 11th 2024
 * This is the introduction Game State.
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class GameIntro extends GameController {

    PImage photo = main.loadImage("./images///bomb_2_w.jpg"); //declaring the image

    GameIntro(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.background(0,128,255);
        main.fill(0);
        main.textSize(45);
        main.image(photo, 50,50, 64,64); ////TEST IMAGE! (img, x,y, width, height)
        main.text("Welcome to Battleship!", (main.width/2) - 100, 250);
        main.textSize(35);
        main.text("Avoid mines and collect coins!", 175, 375);
        // main.text("all while collecting coins!", 290, 425);
        main.text("Press spacebar to play!", 225, 525);
    }
    public void mousePressed()
    {

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

}
