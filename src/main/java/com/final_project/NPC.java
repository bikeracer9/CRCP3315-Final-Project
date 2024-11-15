/*
*   Prescott Lau
* Final Project
* November 11th 2024
*   This is the NPC Class, the superclass for all the NPC objects (loot & enemies).
*/
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class NPC extends Particle_Object{
    NPC(PApplet main_, PImage img_, int img_width_, int img_height_, int a) 
    {
        super(main_, img_, img_width_, img_height_, 255);
        spawn();
    }

    void spawn()
    {
        x = (main.width + 50);
        y = main.random(main.height);

        xVel = main.random(-8,-4);
        // yVel = main.random(-3,-1);
    }

    /*
     * Move function, overrides it to make it so that the enemies will keep spawning in.
     */
    @Override
    void move() 
    {
        {
            x += xVel;

            if(x < (0 - img_height))
            {
                spawn();
            }
        }
    }

    void display()
    {
        super.display();
        //main.ellipse(x, y, size, size);
    }

    void collision(Battleship ship)
    {
        if(isHit(ship))
        {
            spawn();
        }
    }

}
