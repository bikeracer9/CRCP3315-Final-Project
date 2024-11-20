/*
 * Prescott Lau
 * November 19th 2024
 * 
 * This class is the Shop class. 
 * 
 * It allows the user to customize the gameplay: buy more lives, change their appearance.
 */
package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class ShopController extends GameController{
    PImage battleshipImg = main.loadImage("./images/battleship.png");

    LinkedList list = new LinkedList(); 
    GamePlayState game = new GamePlayState(main);
    //Battleship ship = new Battleship(main, battleshipImg );

    ShopController(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.background(0,128,255);
        main.fill(0);
        main.textSize(35);
        main.text("Coins: " + game.updateCoins(), 35, 65);
    }
    
    public void mousePressed()
    {   

    }

    public void setupButtons()
    {
        int x_tR = main.width - 200;
        int y_tR = main.height - 200;
        int spacer = 35;
    }



}
