/*
 * Prescott Lau
 * November 19th 2024 
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Wave extends NPC {
    PImage waveImg_ = main.loadImage("./images/wave_2.png"); //wave.png
    
    Wave(PApplet main_, PImage waveImg_)
    {
        super(main_, waveImg_, 64, 64, 255);  //main_, 45, main_.color(255,0,0)
    }


    @Override
    void collision(Battleship ship) 
    {
        ship.display();
    }

    @Override
    void spawn()
    {
        x = (main.width + 50);
        y = main.random(main.height);

        xVel = main.random(-6, -3); 
    }

}
