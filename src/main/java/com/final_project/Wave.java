package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Wave extends NPC {
    PImage waveImg_ = main.loadImage("./images/wave.png");
    
    Wave(PApplet main_, PImage waveImg_)
    {
        super(main_, waveImg_, 64, 64, 255);  //main_, 45, main_.color(255,0,0)
    }

    @Override
    void collision(Battleship ship) 
    {
        
    }
}
