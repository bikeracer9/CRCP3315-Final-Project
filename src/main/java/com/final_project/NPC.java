/*
*   Prescott Lau
*   September 30th 2024
*   This is the NPC Class, the superclass for all the NPC objects (loot & enemies).
*/
package com.final_project;

import processing.core.PApplet;

public class NPC extends Particle_Object{
    NPC(PApplet main_, float size_, int color_)
    {
        super(main_, size_, color_, 255);
        spawn();
    }

    void spawn()
    {
        x = 800;
        y = main.random(main.height);

        xVel = main.random(-3,-1);
        // yVel = main.random(-3,-1);
    }

    void display()
    {
        super.display();
        main.ellipse(x, y, size, size);
    }

    void collision(Battleship ship)
    {
        if(isHit(ship))
        {
            spawn();
        }
    }

}
