/*
 * Prescott Lau
 * Final Project
 * November 11th 2024
 * This class controls the gameplay and everything related to it.
 */
package com.final_project;

import processing.core.PApplet;

public abstract class GameController {
    PApplet main; //reference to the main class
    
    static final int DO_NOT_CHANGE = -1;
    static final int GAME_PLAY = 0;
    
    static final int GAME_END = 1;
    static final int GAME_WIN = 2;

    static final int INTRO = 3;
    static final int SHOP = 4; //added the shop

    int nextController = DO_NOT_CHANGE;

    GameController(PApplet main_)
    {
        main = main_;
    }

    public abstract void draw();
    public void mouseDragged()
    {
        //do nothing by default!
    }
    public void mousePressed()
    {
        //do nothing by default!
    }
    public void keyPressed()
    {
        //do nothing by default!
    }

    public int switchController()
    {
        return nextController;
    }

    //resets the next controller 
    public void reset()
    {
        nextController = DO_NOT_CHANGE; 
    }
}
