/*
 * Prescott Lau
 * Final Project
 * November 11th 2024
 * This is the enemy class, it is an extension of the NPC class
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy extends NPC
{                                                   ////bomb_2.png
    PImage bombImg_ = main.loadImage("./images/bomb_2_w.jpg"); //declaring the bomb image

    Enemy(PApplet main_, PImage bombImg_)
    { // PApplet main_, PImage img_, int img_width_, int img_height_, int a
        super(main_, bombImg_, 64, 64, 255);  //main_, 45, main_.color(255,0,0)
    }
}
