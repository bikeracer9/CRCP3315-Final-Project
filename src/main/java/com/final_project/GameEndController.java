/*
 * Prescott Lau
 * September 30th
 * This class extends the GameController class and controls the End Screen.
 */
package com.final_project;

import java.util.ArrayList;

import processing.core.PApplet;

public class GameEndController extends GameController {

    ArrayList<OnMousePress> presses = new ArrayList<>(); 
    // ShopButton s = new ShopButton();

    GameEndController(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.background(0);
        main.fill(255);
        main.textSize(35);
        main.text("You Died!", (main.width/2)-125, (main.height/2)-150);
        main.text("Press spacebar to try again!", (main.width/2)-225, (main.height/2)+25);
        addButtons();
    }
    
    public void mousePressed()
    {
        for(OnMousePress press : presses )
        {
            press.mousePressed(main.mouseX, main.mouseY);
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
        int x_tR = main.width - 200; 
        int y_tR = main.height - 200; 

        // ShopButton shopB = new ShopButton(this, x_tR, y_tR);
        // presses.add(shopB);
    }

}
