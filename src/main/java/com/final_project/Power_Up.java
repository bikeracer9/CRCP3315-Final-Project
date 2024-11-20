/*
 * Prescott Lau
 * September 30th 2024
 * This class extends the NPC Class and creates small circles that have random abilities!
 * 
 * Random Ability #1 (if the random_number = 0): Can give you 2 extra lives! 
 * Random Ability #2 (if the random_number = 1): Can give you 3 extra coins!
 * Random Ability #3 (if the random_number = 2): Can take away 2 lives from you!
 * Random Ability #4 (if the random_number = 3): Can take away 3 coins from you!
 * Random Ability #5 (if the random_number = 4, 5, 6, or 7): Do nothing!
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Power_Up extends NPC {
    
    PImage powerUpImg_ = main.loadImage("./images/powerUp_1.png"); //declaring the powerUP image

    Power_Up(PApplet main_, PImage powerUpImg_)
    {
        super(main_, powerUpImg_,40,40,255);
    }

    @Override
    void move() 
    {
        int rand = (int)main.random(0,290);
        {
            x += xVel;

            if(x < (0 - img_height))
            {
                if(rand == 1)
                {
                    spawn(); //respawn the powerUp if the number = 1. 
                    
                }
                else if(rand != 1) //do nothing if the random number is NOT 1. 
                {

                }
                
                //System.out.println("Rand: " + rand); //test
            }
        }
    }

}
