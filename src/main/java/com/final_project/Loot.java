/*
 * Prescott Lau
 * Final Project
 * November 11th 2024
 * This is the Loot Class, which are coins that allows a user to win the game!
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Loot extends NPC {

    PImage coinImg_ = main.loadImage("./images/coin.png"); //declaring the coin image

    //loot is yellow and spawns randommly
    Loot(PApplet main_, PImage coinImg_)
    {
        super(main_, coinImg_, 46, 46, 255);
    }
    

}
