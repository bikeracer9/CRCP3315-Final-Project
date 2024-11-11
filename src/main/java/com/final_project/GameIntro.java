/*
 * Prescott Lau 
 * November 11th 2024
 * This is the introduction Game State.
 */
package com.final_project;

import processing.core.PApplet;

public class GameIntro extends GameController {

    GameIntro(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.background(0);
        main.fill(255);
        main.textSize(35);
        main.text("Welcome to Battleship!", (main.width/2)-200, (main.height/2)-150);
        main.text("Press spacebar to start playing!", (main.width/2)-275, (main.height/2)+25);
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
