/*
 * Prescott Lau
 * September 30th
 * This class extends the GameController class and controls the End Screen.
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class GameEndController extends GameController {

    PImage death_pic = main.loadImage("./images/death_pic.png"); //declaring the image

    GameEndController(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.background(63, 159, 252);
        main.fill(0);
        main.textSize(55);
        main.image(death_pic, 0,0, 1400, 800);
        //main.text("You died!", (main.width/2)-120, (main.height/2)-150);
        //main.text("Press spacebar to try again!", (main.width/2)-225, (main.height/2)+25);
        
        addButtons();
    }
    
    public void mousePressed()
    {
        System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!

        //PLAY AGAIN
        if( (main.mouseX >= 588) && (main.mouseX <= 812) && (main.mouseY >= 363) && (main.mouseY <= 437) )
        {
            nextController = GameController.GAME_PLAY; //go to gameplay!
        }

        //ATTEMPTS PAGE (SHOWS ALL YOUR PAST ATTEMPTS)
        if( (main.mouseX >= 588) && (main.mouseX <= 812) && (main.mouseY >= 472) && (main.mouseY <= 546) )
        {
            nextController = GameController.ATTEMPTS; //go to information about the game!
        }

        //SHOP
        if( (main.mouseX >= 588) && (main.mouseX <= 812) && (main.mouseY >= 583) && (main.mouseY <= 657) )
        {
            nextController = GameController.SHOP; //go to information about the game!
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

    public void addButtons()
    {
        //Play Again Button below:
        main.fill(255);
        main.rectMode(3);
        main.rect(main.width/2, main.height/2, 225,75 );
        main.fill(0);
        main.textSize(40);
        main.text("Play Again", main.width/2 - 98, main.height/2 + 15 );

        //Attempts button below:
        main.fill(255);
        main.rect(main.width/2, main.height/2 + 109, 225,75 ); //120
        main.fill(0);
        main.textSize(40);
        main.text("Attempts", main.width/2 - 85, main.height/2 + 122 );

        //Shop button below:
        main.fill(255);
        main.rect(main.width/2, main.height/2 + 220, 225,75 );
        main.fill(0);
        main.textSize(40);
        main.text("Shop", main.width/2 - 48, main.height/2 + 235 );
        
    }

}
